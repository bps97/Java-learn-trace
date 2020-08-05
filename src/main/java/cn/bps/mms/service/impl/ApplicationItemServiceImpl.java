package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.model.MaterialDto;
import cn.bps.mms.model.MaterialUploadDataListener;
import cn.bps.mms.model.ao.ApplicationItemAo;
import cn.bps.mms.model.vo.ApplicationItemVo;
import cn.bps.mms.model.enums.ApplicationType;
import cn.bps.mms.mapper.ApplicationItemMapper;
import cn.bps.mms.model.pojo.*;
import cn.bps.mms.service.*;
import cn.bps.security.server.service.TokenService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 申请单项 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class ApplicationItemServiceImpl extends ServiceImpl<ApplicationItemMapper, ApplicationItem> implements ApplicationItemService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private WarehouseService warehouseService;

    @Resource
    private ApplicationService applicationService;

    @Resource
    private TokenService tokenService;


    @Override
    public void addItem(ApplicationItemAo ao, String tokenValue) {

        ApplicationItem item = ao2Model(ao);

        Application application = applicationService.getUserApplication(tokenValue, ao.getEnum());
        item.setApplicationId(application.getId());

        String categoryId = item.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        item.setCategoryName(categoryName);
        String specialLine = categoryService.getSpecialLine(categoryId);
        item.setSpecialLine(specialLine);

        String materialId = item.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        item.setMaterialName(materialName);

        String warehouseId  = item.getWarehouseId();
        String warehouseName = warehouseService.getById(warehouseId).getName();
        item.setWarehouseName(warehouseName);

        this.save(item);
    }



    @Override
    public List<ApplicationItemVo> list(String tokenValue) {

        Application application = applicationService.getUserApplication(tokenValue);

        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_id", application.getId());
        List<ApplicationItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public List<ApplicationItemVo> list(String tokenValue, ApplicationType type) {

        Application application = applicationService.getUserApplication(tokenValue, type);

        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_id", application.getId())
                .orderByDesc("update_time");
        List<ApplicationItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public void closeItems(Application application) {
        ApplicationItem item = new ApplicationItem();
        item.setAvailable(false);
        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_id", application.getId());
        this.update(item,wrapper);
    }

    @Override
    public List<ApplicationItem> list(Application application) {
        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("application_id", application.getId());
        return this.list(wrapper);
    }

    @Override
    public Application initBatchImport(Account account, String type) {
        if(ApplicationType.excelImport.getType().equals(type))
            return applicationService.getUserApplication(account, ApplicationType.excelImport);
        return applicationService.getUserApplication(account);
    }

    /**
     * 补充关联信息，例如ID
     * @param applicationItems
     * @return
     */
    @Override
    public List<ApplicationItem> initRelatedInfo(List<ApplicationItem> applicationItems) {
        return applicationItems.stream().map(this::initIdInfo).collect(Collectors.toList());
    }

    private ApplicationItem initIdInfo(ApplicationItem item) {
        Category category = categoryService.getByCategoryNameAndSpecialLine(item.getCategoryName(),item.getSpecialLine());
        if(Objects.isNull(category)) {
            throw new LocalBizServiceException(CustomizeExceptionCode.CATEGORY_NOT_EXIST, String.format("导入的文件中【分类】-%s中不存在", item.getMaterialName()));
        }
        item.setCategoryId(category.getId());
        String warehouseId = warehouseService.getIdByName(item.getWarehouseName());
        item.setWarehouseId(warehouseId);
        Material material = materialService.getOneByKey(item.getMaterialName(), item.getWarehouseId(), item.getStatus());
        if(Objects.nonNull(material)){
            item.setMaterialId(material.getId());
        }
        return item;
    }


    @Override
    public IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, Account account) {
        Application application = applicationService.getUserApplication(account);
        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper.eq("available", true)
                .eq("application_id", application.getId());
        return this.page(page, wrapper);
    }

    @Override
    public IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, String token, ApplicationType type) {
        Account account = tokenService.getAccount(token);
        return pageMaterials(page, account, type);
    }

    @Override
    public IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, Account account, ApplicationType type) {
        Application application = applicationService.getUserApplication(account, type);
        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper.eq("available", true)
                .eq("application_id", application.getId())
                .orderByDesc("update_time");
        return this.page(page, wrapper);
    }

    @Override
    public IPage<ApplicationItem> handleExcelStream(MultipartFile file, String token, Application form) throws IOException {
        Account account = tokenService.getAccount(token);
        easyExcelRead(file, account, form);
        return pageMaterials(new Page<>(), account);
    }

    @Override
    public Material checkMaterial(ApplicationItemAo ao) {
        Material material = materialService.getOneByKey(ao.getMaterialName(), ao.getWarehouseId(), ao.getStatus());
        if(Objects.isNull(material)){
            material = new Material();
            material.setName(ao.getMaterialName());
            material.setCategoryId(ao.getCategoryId());
            material.setStatus(ao.getStatus());
            material.setWarehouseId(ao.getWarehouseId());
            material.setSpecialLine(categoryService.getSpecialLine(ao.getCategoryId()));
            materialService.save(material);
            material = materialService.getOneByKey(ao.getMaterialName(), ao.getWarehouseId(), ao.getStatus());
        }
        return material;
    }


    /**
     * 来自EasyExcel的模版代码
     * @param file
     * @param account
     * @throws IOException
     */
    private void easyExcelRead(MultipartFile file, Account account, Application form) throws IOException {
        EasyExcel.read(file.getInputStream(),
                MaterialDto.class,new MaterialUploadDataListener(this, account, form))
                .sheet().doRead();
    }

    private ApplicationItemVo model2Vo(ApplicationItem item){
        ApplicationItemVo vo = new ApplicationItemVo();
        vo.setId(item.getId());
        vo.setMaterialName(item.getMaterialName());
        vo.setStatus(item.getStatus());
        vo.setCategoryName(item.getCategoryName());
        vo.setWarehouseName(item.getWarehouseName());
        vo.setCount(item.getCount());
        vo.setSpecialLine(materialService.getById(item.getMaterialId()).getSpecialLine());
        return vo;
    }

    private ApplicationItem ao2Model(ApplicationItemAo ao) {
        ApplicationItem item = new ApplicationItem();
        item.setMaterialId(ao.getMaterialId());
        item.setWarehouseId(ao.getWarehouseId());
        item.setCategoryId(ao.getCategoryId());
        item.setCount(ao.getCount());
        item.setStatus(ao.getStatus());
        return item;
    }
}