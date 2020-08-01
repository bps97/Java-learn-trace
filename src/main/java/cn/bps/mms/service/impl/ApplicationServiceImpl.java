package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.domain.ao.ApplicationAo;
import cn.bps.mms.entity.*;
import cn.bps.mms.domain.ApplicationType;
import cn.bps.mms.mapper.ApplicationMapper;
import cn.bps.mms.service.ApplicationItemService;
import cn.bps.mms.service.ApplicationService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.service.RecordService;
import cn.bps.security.server.service.TokenService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Objects;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 申请单 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-07-24
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Resource
    private TokenService tokenService;

    @Resource
    private ApplicationItemService ApplicationItemService;

    @Resource
    private RecordService recordService;

    @Resource
    private MaterialService materialService;


    @Override
    public Application getUserApplication(Account account) {
        return getUserApplication(account, null);
    }

    @Override
    public Application getUserApplication(Account account, ApplicationType type) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("user_id", account.getId());

        if(type != null){
            wrapper.eq("type", type.getType());
        }
        wrapper.orderByDesc("create_time");
        List<Application> applications = this.list(wrapper);
        Application application = null;
        if(applications.isEmpty()){
            application = new Application();
            application.setUserId(account.getId());
            if(type != null){
               application.setType(type.getType());
            }
            if(StringUtils.isEmpty(account.getUsername())){
                throw new LocalBizServiceException(CustomizeExceptionCode.LACK_OF_INFORMATION,"请补全该账户用户信息");
            }else{
                application.setUserName(account.getName());
            }
            application.setUserName(account.getName());
            this.save(application);
        }else {
            application = applications.get(0);
        }
        return application;
    }

    @Override
    public Application getUserApplication(String tokenValue) {
        Account account = tokenService.getAccount(tokenValue);
        return getUserApplication(account);
    }

    @Override
    public Application getUserApplication(String tokenValue, ApplicationType type) {
        Account account = tokenService.getAccount(tokenValue);
        return getUserApplication(account, type);
    }

    @Override
    public void addMessage(ApplicationAo ao, String tokenValue) {
        Application myApplication = getUserApplication(tokenValue, ao.getEnum());
        myApplication.setMessage(ao.getMessage());
        myApplication.setType(ao.getType());


        List<ApplicationItem> applicationItems = ApplicationItemService.list(myApplication);
        if(applicationItems.size() <= 0){
            throw new LocalBizServiceException(CustomizeExceptionCode.NO_CACHE_DATA,"没有缓存数据");
        }



        if(Objects.equal(myApplication.getType(), ApplicationType.excelImport.getType())){

            /* 新增未被系统记录的物料 */
            saveNewMaterials(applicationItems);
            /* 更新仓库中已有的物料 */
            updateMaterials(applicationItems);
            /* 同步申请单项信息，例如materialId */
            synApplicationItemNewInfo(applicationItems);

        }else if(Objects.equal(myApplication.getType(), ApplicationType.warehouseEntry.getType())) {
            /*逐项录入的数据是完整的*/
            updateMaterials(applicationItems);
        }

        // 清空清单项
        ApplicationItemService.closeItems(myApplication);

        // 记录信息
        recordService.record(myApplication);

        // 关闭清单
        myApplication.setAvailable(false);
        this.updateById(myApplication);

    }

    private void synApplicationItemNewInfo(List<ApplicationItem> applicationItems) {
        applicationItems = applicationItems.stream()
                .filter(e -> StringUtils.isEmpty(e.getMaterialId()))
                .map(e -> {
                    Material material = materialService.getOneByKey(e.getMaterialName(), e.getWarehouseId(), e.getStatus());
                    e.setMaterialId(material.getId());
                    return e;
                }).collect(Collectors.toList());
        ApplicationItemService.updateBatchById(applicationItems);
    }

    private void saveNewMaterials(List<ApplicationItem> applicationItems) {
        /* 未被系统记录的物料,因为该物料在系统中未导入所以没有其ID信息 */
        List<Material> newMaterials = applicationItems.stream()
                .filter(e -> StringUtils.isEmpty(e.getMaterialId()) == Boolean.TRUE)
                .map(this::initMaterial)
                .collect(Collectors.toList());
        materialService.saveBatch(newMaterials);
    }

    private void updateMaterials(List<ApplicationItem> applicationItems) {
        /* 仓库中已有的物料 */
        List<Material> updateMaterials = applicationItems.stream()
                .filter(e -> StringUtils.isEmpty(e.getMaterialId())  == Boolean.FALSE)
                .map(this::initMaterial).collect(Collectors.toList());

        if(updateMaterials.size() > 0){
            Set<String> ids = updateMaterials.stream()
                    .map(Material::getId)
                    .collect(Collectors.toSet());
            Collection<Material> materials = materialService.listByIds(ids);
            Map<String, Integer> oldMaterials = materials.stream()
                    .collect(Collectors.toMap(Material::getId, Material::getCount));
            updateMaterials.stream()
                    .map(e-> e.setCount(e.getCount()+ oldMaterials.get(e.getId()))).collect(Collectors.toList());
            materialService.updateBatchById(updateMaterials);
        }
    }


    private Material initMaterial(ApplicationItem item){
        Material material = new Material();

        String materialId = item.getMaterialId();

        if(StringUtils.isEmpty(materialId)){
            material.setName(item.getMaterialName());
            material.setCategoryId(item.getCategoryId());
            material.setWarehouseId(item.getWarehouseId());
            material.setSpecialLine(item.getSpecialLine());
            material.setStatus(item.getStatus());
        }else {
            material.setId(materialId);
        }
        material.setCount(item.getCount());
        return material;
    }
}
