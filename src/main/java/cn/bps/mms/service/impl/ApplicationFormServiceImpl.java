package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.entity.Material;
import cn.bps.mms.mapper.ApplicationFormMapper;
import cn.bps.mms.service.ApplicationFormItemService;
import cn.bps.mms.service.ApplicationFormService;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 申请单 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class ApplicationFormServiceImpl extends ServiceImpl<ApplicationFormMapper, ApplicationForm> implements ApplicationFormService {

    @Resource
    private TokenService tokenService;

    @Resource
    private ApplicationFormItemService applicationFormItemService;

    @Resource
    private RecordService recordService;

    @Resource
    private MaterialService materialService;

    @Override
    public ApplicationForm getApplication(Account account) {
        QueryWrapper<ApplicationForm> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("user_id", account.getId());
        List<ApplicationForm> applicationForms = this.list(wrapper);
        ApplicationForm applicationForm = null;
        if(applicationForms.isEmpty()){
            applicationForm = new ApplicationForm();
            applicationForm.setUserId(account.getId());
            applicationForm.setUserName(account.getName());
            this.save(applicationForm);
        }else {
            applicationForm = applicationForms.get(0);
        }
        return applicationForm;
    }

    @Override
    public ApplicationForm getApplication(String tokenValue) {
        Account account = tokenService.getAccount(tokenValue);
        return getApplication(account);
    }

    @Override
    public void addMessage(ApplicationForm applicationForm, String tokenValue) {
        ApplicationForm myApplicationForm = getApplication(tokenValue);
        myApplicationForm.setMessage(applicationForm.getMessage());
        if(Objects.equal(myApplicationForm.getType(),"批量导入")){
            // 同步物料表
            List<ApplicationFormItem> applicationFormItems = applicationFormItemService.list(myApplicationForm);
            Stream<Material> materials = applicationFormItems.stream().map(this::initMaterial);
            List<Material> newMaterials = materials.filter(e -> StringUtils.isEmpty(e.getId()) == Boolean.FALSE).collect(Collectors.toList());
            materialService.saveBatch(newMaterials);

            List<Material> updateMaterials = materials.filter(e -> StringUtils.isEmpty(e.getId()) == Boolean.FALSE).collect(Collectors.toList());
            Collection<Material> oldMaterials = materialService.listByIds(updateMaterials.stream().map(Material::getId).collect(Collectors.toSet()));
            Map<String, List<Material>> xx = updateMaterials.stream().collect(Collectors.groupingBy(Material::getName));

        }else{
            myApplicationForm.setType("领用");
        }

        // 清空清单项
//        applicationFormItemService.closeItems(myApplicationForm);

        // 记录信息
        recordService.record(myApplicationForm);

        // 关闭清单
//        myApplicationForm.setAvailable(false);
        this.updateById(myApplicationForm);

    }

    private Material initMaterial(ApplicationFormItem item){
        Material material = new Material();

        String materialId = item.getMaterialId();

        if(StringUtils.isEmpty(material)){
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
