package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.domain.ao.MaterialAo;
import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Material;
import cn.bps.mms.mapper.MaterialMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.domain.vo.KeyValue;
import cn.bps.mms.domain.vo.MaterialVo;
import cn.bps.mms.service.RepositoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 物料 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {


    @Resource
    private CategoryService categoryService;

    @Resource
    private RepositoryService repositoryService;



    @Override
    public List<Material> listMaterials(String categoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("category_id",categoryId);
        return this.list(wrapper);
    }

    @Override
    public List<Material> listMaterialsByRepositoryId(String repositoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("repository_id", repositoryId);
        return this.list(wrapper);
    }

    @Override
    public List<Material> listMaterialsByRepositoryId(String categoryId, String repositoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("repository_id", repositoryId)
                .eq("category_id",categoryId);
        return this.list(wrapper);
    }

    @Override
    public List<KeyValue> listMaterialNames(String categoryId, String repositoryId) {
        List<Material> materials = repositoryId.isEmpty() ? listMaterials(categoryId) : listMaterialsByRepositoryId(categoryId, repositoryId);
        return materials.stream().map(e->{
            KeyValue keyValue = new KeyValue();
            keyValue.setKey(e.getId());
            keyValue.setValue(e.getName());
            return keyValue;
        }).collect(Collectors.toList());
    }

    @Override
    public IPage<MaterialVo> pageMaterials(Page<Material> page, MaterialAo ao) {


        String categoryId = ao.getCategoryId();
        if(Objects.equals(categoryId,"")){
            throw new LocalBizServiceException(CustomizeExceptionCode.REQUEST_PARAMS_IS_EMPTY);
        }
        Set<String> children = categoryService.getAllChildren(categoryId)
                .stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
        if(children.size() == 0){
            throw new LocalBizServiceException(CustomizeExceptionCode.RESOURCE_NOT_FOUND);
        }
        children.add(categoryId);
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper.in("category_id",children);
        String key = ao.getKey();
        if(key.isEmpty() == Boolean.FALSE){
            wrapper.like("name",key);
        }
        wrapper.orderByAsc("name").orderByAsc("update_time");

        IPage<Material> pageMaterial = this.page(page, wrapper);
        List vos = (List) pageMaterial.getRecords()
                .stream()
                .map(this::model2Vo)
                .collect(Collectors.toList());
        IPage<MaterialVo> iPage =  pageMaterial.setRecords(vos);

        return iPage;
    }

    @Override
    public String getIdByName(String materialName) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("name", materialName);
        Material material = this.getOne(wrapper,false);
        return Objects.isNull(material) ? null : material.getName();
    }

    @Override
    public void saveMaterial(Material material) {
        if(StringUtils.isEmpty(material.getStatus())){
            material.setStatus("正常");
        }
        Material old = validateExist(material);
        if(Objects.isNull(old)){
            String specialLine = categoryService.getRootCategoryName(material.getCategoryId());
            material.setSpecialLine(specialLine);
            this.save(material);
        }else {
            old.setCount(material.getCount()+old.getCount());
            this.updateById(old);
        }
    }

    @Override
    public void updateById(String id, Material material) {
        material.setId(id);
        this.updateById(material);
    }

    @Override
    public MaterialVo getVoById(String id) {
        return model2Vo(this.getById(id));
    }

    @Override
    public Material validateExist(Material material) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("name", material.getName())
                .eq("repository_id", material.getCategoryId())
                .eq("status", material.getStatus());
        return this.getOne(wrapper);
    }

    @Override
    public Map<String, Map<String, String>> getNameStatusIdDict(Set<String> materialNames) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper.in("name",materialNames);
        List<Material> materials = this.list(wrapper);
        return materials.stream()
                .collect(Collectors.groupingBy(
                        Material::getName,
                        Collectors.toMap(Material::getStatus, Material::getId)));
    }

    private MaterialVo model2Vo(Material material){
        MaterialVo vo = new MaterialVo();
        vo.setName(material.getName());
        vo.setAvailable(material.getAvailable());
        vo.setCategoryId(material.getCategoryId());
        vo.setCount(material.getCount());
        vo.setCreateTime(material.getCreateTime());
        vo.setUpdateTime(material.getUpdateTime());
        vo.setId(material.getId());
        vo.setRepositoryId(material.getRepositoryId());
        vo.setRepositoryName(repositoryService.getById(material.getRepositoryId()).getName());
        vo.setSpecialLine(material.getSpecialLine());
        vo.setCategoryName(categoryService.getById(material.getCategoryId()).getName());
        vo.setStatus(material.getStatus());
        return vo;
    }
    private MaterialVo model2Vo(Object obj){
        obj = (Material)obj;
        return model2Vo(obj);
    }

}
