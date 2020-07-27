package cn.bps.mms.service.impl;

import cn.bps.mms.domain.MaterialEo;
import cn.bps.mms.domain.MaterialUploadDataListener;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppFormItem;
import cn.bps.mms.entity.AppForm;
import cn.bps.mms.enums.AppFormType;
import cn.bps.mms.mapper.AppFormItemMapper;
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
import java.util.Map;
import java.util.Set;
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
public class AppFormItemServiceImpl extends ServiceImpl<AppFormItemMapper, AppFormItem> implements AppFormItemService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private AppFormService appFormService;

    @Resource
    private TokenService tokenService;


    @Override
    public void addItem(AppFormItem item, String tokenValue) {



        AppForm appForm = appFormService.getApplication(tokenValue);
        item.setAppFormId(appForm.getId());

        String categoryId = item.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        item.setCategoryName(categoryName);

        String materialId = item.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        item.setMaterialName(materialName);

        String repositoryId  = item.getRepositoryId();
        String repositoryName = repositoryService.getById(repositoryId).getName();
        item.setRepositoryName(repositoryName);

        this.save(item);
    }

    @Override
    public List<ApplicationItemVo> list(String tokenValue) {

        AppForm appForm = appFormService.getApplication(tokenValue);

        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("app_form_id", appForm.getId());
        List<AppFormItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public List<ApplicationItemVo> list(String tokenValue, AppFormType type) {

        AppForm appForm = appFormService.getApplication(tokenValue, type);

        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("app_form_id", appForm.getId());
        List<AppFormItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public void closeItems(AppForm appForm) {
        AppFormItem item = new AppFormItem();
        item.setAvailable(false);
        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("app_form_id", appForm.getId());
        this.update(item,wrapper);
    }

    @Override
    public List<AppFormItem> list(AppForm appForm) {
        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("app_form_id", appForm.getId());
        return this.list(wrapper);
    }

    @Override
    public AppForm initBatchImport(Account account, String type) {
        if(AppFormType.excelImport.getType().equals(type))
            return appFormService.getApplication(account, AppFormType.excelImport);
        return appFormService.getApplication(account);
    }

    @Override
    public List<AppFormItem> initName2Id(List<AppFormItem> appFormItems) {


        Set<String> categoryNames = appFormItems.stream()
                .map(AppFormItem::getCategoryName)
                .collect(Collectors.toSet());

        Set<String> materialNames = appFormItems.stream()
                .map(AppFormItem::getMaterialName)
                .collect(Collectors.toSet());

        Map<String, String> categoryNameIdDict = categoryService.getNameIdDict(categoryNames);
        Map<String, String> repositoryNameIdDict = repositoryService.getNameIdDict();
        Map<String, Map<String, String>> materialNameStatusIdDict = materialService.getNameStatusIdDict(materialNames);


        appFormItems = appFormItems.stream().map(e->{
            e.setCategoryId(categoryNameIdDict.get(e.getCategoryName()));
            e.setRepositoryId(repositoryNameIdDict.get(e.getRepositoryName()));
            Map<String, String> statusIdDict = materialNameStatusIdDict.get(e.getMaterialName());
            if(statusIdDict != null){
                e.setMaterialId(statusIdDict.get(e.getStatus()));
            }
            return e;
        }).collect(Collectors.toList());


        return appFormItems;
    }


    @Override
    public IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, Account account) {
        AppForm appForm = appFormService.getApplication(account);
        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper.eq("available", true)
                .eq("app_form_id", appForm.getId());
        return this.page(page, wrapper);
    }

    @Override
    public IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, String token, AppFormType type) {
        Account account = tokenService.getAccount(token);
        return pageMaterials(page, account, type);
    }

    @Override
    public IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, Account account, AppFormType type) {
        AppForm appForm = appFormService.getApplication(account, type);
        QueryWrapper<AppFormItem> wrapper = new QueryWrapper<>();
        wrapper.eq("available", true)
                .eq("app_form_id", appForm.getId());
        return this.page(page, wrapper);
    }

    @Override
    public IPage<AppFormItem> handleExcelStream(MultipartFile file, String token, AppForm form) throws IOException {
        Account account = tokenService.getAccount(token);
        easyExcelRead(file, account, form);
        return pageMaterials(new Page<>(), account);
    }


    /**
     * 来自EasyExcel的模版代码
     * @param file
     * @param account
     * @throws IOException
     */
    private void easyExcelRead(MultipartFile file, Account account, AppForm form) throws IOException {
        EasyExcel.read(file.getInputStream(),
                MaterialEo.class,new MaterialUploadDataListener(this,account, form))
                .sheet().doRead();
    }

    private ApplicationItemVo model2Vo(AppFormItem item){
        ApplicationItemVo vo = new ApplicationItemVo();
        vo.setId(item.getId());
        vo.setMaterialName(item.getMaterialName());
        vo.setStatus(item.getStatus());
        vo.setCategoryName(item.getCategoryName());
        vo.setRepositoryName(item.getRepositoryName());
        vo.setCount(item.getCount());
        vo.setSpecialLine(materialService.getById(item.getMaterialId()).getSpecialLine());
        return vo;
    }
}