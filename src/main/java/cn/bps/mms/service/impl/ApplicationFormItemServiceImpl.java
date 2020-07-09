package cn.bps.mms.service.impl;

import cn.bps.mms.domain.MaterialEo;
import cn.bps.mms.domain.MaterialUploadDataListener;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.mapper.ApplicationFormItemMapper;
import cn.bps.mms.service.*;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.security.server.service.TokenService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
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
public class ApplicationFormItemServiceImpl extends ServiceImpl<ApplicationFormItemMapper, ApplicationFormItem> implements ApplicationFormItemService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private ApplicationFormService applicationFormService;

    @Resource
    private TokenService tokenService;


    @Override
    public void addItem(ApplicationFormItem item, String tokenValue) {

        

        ApplicationForm applicationForm = applicationFormService.getApplication(tokenValue);
        item.setApplicationFormId(applicationForm.getId());

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

        ApplicationForm applicationForm = applicationFormService.getApplication(tokenValue);

        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_form_id", applicationForm.getId());
        List<ApplicationFormItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public void closeItems(ApplicationForm applicationForm) {
        ApplicationFormItem item = new ApplicationFormItem();
        item.setAvailable(false);
        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_form_id", applicationForm.getId());
        this.update(item,wrapper);
    }

    @Override
    public List<ApplicationFormItem> list(ApplicationForm applicationForm) {
        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("application_form_id", applicationForm.getId());
        return this.list(wrapper);
    }

    @Override
    public ApplicationForm initBatchImport(Account account) {
        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setUserId(account.getId());
        applicationForm.setType("批量导入");
        applicationForm.setUserName(account.getName());
        applicationFormService.save(applicationForm);
        return applicationFormService.getApplication(account);
    }

    @Override
    public ApplicationFormItem initName2Id(ApplicationFormItem applicationForm) {

        String categoryId = categoryService.getIdByCategoryName(applicationForm.getCategoryName());
        applicationForm.setCategoryId(categoryId);
        String repositoryId  = repositoryService.getIdByName(applicationForm.getRepositoryName());
        applicationForm.setRepositoryId(repositoryId);

        String materialName = applicationForm.getMaterialName();
        if(StringUtils.isEmpty(materialName) == Boolean.FALSE){
            String materialId = materialService.getIdByName(materialName);
            applicationForm.setMaterialId(materialId);
        }
        return applicationForm;
    }



    @Override
    public IPage<ApplicationFormItem> pageMaterials(Page<ApplicationFormItem> page, String token) {
        Account account = tokenService.getAccount(token);
        return pageMaterials(page,account);
    }

    @Override
    public IPage<ApplicationFormItem> pageMaterials(Page<ApplicationFormItem> page, Account account) {
        ApplicationForm applicationForm = applicationFormService.getApplication(account);
        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper.eq("available", true)
                .eq("application_form_id", applicationForm.getId());
        return this.page(page, wrapper);
    }

    @Override
    public IPage<ApplicationFormItem> handleExcelStream(MultipartFile file, String token) throws IOException {
        Account account = tokenService.getAccount(token);
        easyExcelRead(file, account);
        return pageMaterials(new Page<>(), account);
    }


    /**
     * 来自EasyExcel的模版代码
     * @param file
     * @param account
     * @throws IOException
     */
    private void easyExcelRead(MultipartFile file, Account account) throws IOException {
        EasyExcel.read(file.getInputStream(),
                MaterialEo.class,new MaterialUploadDataListener(this,account))
                .sheet().doRead();
    }

    private ApplicationItemVo model2Vo(ApplicationFormItem item){
        ApplicationItemVo vo = new ApplicationItemVo();
        vo.setId(item.getId());
        vo.setMaterialName(item.getMaterialName());
        vo.setCategoryName(item.getCategoryName());
        vo.setRepositoryName(item.getRepositoryName());
        vo.setCount(item.getCount());
        vo.setSpecialLine(materialService.getById(item.getMaterialId()).getSpecialLine());
        return vo;
    }
}
