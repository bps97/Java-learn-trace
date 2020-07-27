package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.entity.*;
import cn.bps.mms.enums.AppFormType;
import cn.bps.mms.mapper.AppFormMapper;
import cn.bps.mms.service.AppFormItemService;
import cn.bps.mms.service.AppFormService;
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
public class AppFormServiceImpl extends ServiceImpl<AppFormMapper, AppForm> implements AppFormService {

    @Resource
    private TokenService tokenService;

    @Resource
    private AppFormItemService AppFormItemService;

    @Resource
    private RecordService recordService;

    @Resource
    private MaterialService materialService;


    @Override
    public AppForm getApplication(Account account) {
        return getApplication(account, null);
    }

    @Override
    public AppForm getApplication(Account account, AppFormType type) {
        QueryWrapper<AppForm> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("user_id", account.getId());

        if(type != null){
            wrapper.eq("type", type.getType());
        }
        wrapper.orderByDesc("create_time");
        List<AppForm> appForms = this.list(wrapper);
        AppForm appForm = null;
        if(appForms.isEmpty()){
            appForm = new AppForm();
            appForm.setUserId(account.getId());
            if(type != null){
               appForm.setType(type.getType());
            }
            if(StringUtils.isEmpty(account.getUsername())){
                throw new LocalBizServiceException(CustomizeExceptionCode.LACK_OF_INFORMATION,"请补全该账户用户信息");
            }else{
                appForm.setUserName(account.getName());
            }
            appForm.setUserName(account.getName());
            this.save(appForm);
        }else {
            appForm = appForms.get(0);
        }
        return appForm;
    }

    @Override
    public AppForm getApplication(String tokenValue) {
        Account account = tokenService.getAccount(tokenValue);
        return getApplication(account);
    }

    @Override
    public AppForm getApplication(String tokenValue, AppFormType type) {
        Account account = tokenService.getAccount(tokenValue);
        return getApplication(account, type);
    }

    @Override
    public void addMessage(AppForm AppForm, String tokenValue) {
        AppForm myAppForm = getApplication(tokenValue);
        myAppForm.setMessage(AppForm.getMessage());
        myAppForm.setType(AppForm.getType());
        if(Objects.equal(myAppForm.getType(),"批量导入")){
            // 同步物料表
            List<AppFormItem> AppFormItems = AppFormItemService.list(myAppForm);

            if(AppFormItems.size() <= 0){
                throw new LocalBizServiceException(CustomizeExceptionCode.NO_CACHE_DATA,"没有缓存数据");
            }

            /* 新的物料 */
            List<Material> newMaterials = AppFormItems.stream().map(this::initMaterial).filter(e -> StringUtils.isEmpty(e.getId()) == Boolean.TRUE).collect(Collectors.toList());
            materialService.saveBatch(newMaterials);

            /* 仓库中已有的物料 */
            List<Material> updateMaterials = AppFormItems.stream().map(this::initMaterial).filter(e -> StringUtils.isEmpty(e.getId()) == Boolean.FALSE).collect(Collectors.toList());
            if(updateMaterials.size()>0){
                Collection<Material> materials = materialService.listByIds(updateMaterials.stream()
                        .map(Material::getId)
                        .collect(Collectors.toSet()));
                Map<String, Integer> oldMaterials = materials.stream().collect(Collectors.toMap(Material::getId, Material::getCount));
                updateMaterials.stream().map(e-> e.setCount(e.getCount()+oldMaterials.get(e.getId()))).collect(Collectors.toList());
                materialService.updateBatchById(updateMaterials);
            }


            /* 同步申请单项 */
            Set<String> materialNames = AppFormItems.stream()
                    .map(AppFormItem::getMaterialName).collect(Collectors.toSet());
            Map<String, Map<String, String>> nameStatusIdDict = materialService.getNameStatusIdDict(materialNames);
            AppFormItems = AppFormItems.stream().filter(e -> StringUtils.isEmpty(e.getMaterialId())).map(e -> {
                Map<String, String> statusIdDict = nameStatusIdDict.get(e.getMaterialName());
                if(statusIdDict != null){
                    e.setMaterialId(statusIdDict.get(e.getStatus()));
                }
                return e;
            }).collect(Collectors.toList());
            if(AppFormItems.size() > 0){
                AppFormItemService.updateBatchById(AppFormItems);
            }
        }

        // 清空清单项
        AppFormItemService.closeItems(myAppForm);

        // 记录信息
        recordService.record(myAppForm);

        // 关闭清单
        myAppForm.setAvailable(false);
        this.updateById(myAppForm);

    }

    private Material initMaterial(AppFormItem item){
        Material material = new Material();

        String materialId = item.getMaterialId();

        if(StringUtils.isEmpty(materialId)){
            material.setName(item.getMaterialName());
            material.setCategoryId(item.getCategoryId());
            material.setRepositoryId(item.getRepositoryId());
            material.setSpecialLine(item.getSpecialLine());
            material.setStatus(item.getStatus());
        }else {
            material.setId(materialId);
        }
        material.setCount(item.getCount());
        return material;
    }
}
