package cn.bps.mms.service.impl;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Material;
import cn.bps.mms.mapper.MaterialMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.vo.KeyValue;
import cn.bps.mms.vo.MaterialVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Resource
    private MaterialService materialService;

    @Resource
    private CategoryService categoryService;

    @Override
    public Page<MaterialVo> pageMaterials(PageRequest pageRequest, String categoryId, String key) {
        List<Material> materials = Lists.newArrayList();
        if(key.isEmpty() ==false){
            materials = listMaterials(categoryId, key);
        } else{
            materials = listMaterials(categoryId);
        }
        List<MaterialVo> materialVos = materials.stream().map(this::model2Vo).collect(Collectors.toList());
        Page<MaterialVo> page = new Page<>(materialVos);
        pageRequest.initPage(page);
        return page;
    }

    @Override
    public List<Material> listMaterials(String categoryId, String key) {
    // 需要考虑优化
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("category_id",categoryId)
                .like("name",key);
        return this.list(wrapper);
    }

    @Override
    public List<Material> listMaterials(String categoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("category_id",categoryId);
        return this.list(wrapper);
    }

    @Override
    public List<KeyValue> listMaterialNames(String categoryId) {
        return listMaterials(categoryId).stream().map(e->{
            KeyValue keyValue = new KeyValue();
            keyValue.setKey(e.getId());
            keyValue.setValue(e.getName());
            return keyValue;
        }).collect(Collectors.toList());
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
        vo.setSpecialLine(material.getSpecialLine());
        Category category = categoryService.getById(material.getCategoryId());
        vo.setCategoryName(category.getName());
        return vo;
    }
}
