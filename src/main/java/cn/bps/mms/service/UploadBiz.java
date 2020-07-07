package cn.bps.mms.service;

import cn.bps.mms.entity.Material;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class UploadBiz {

    @Resource
    private MaterialService materialService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private RepositoryService repositoryService;


    public String getIdByName(String name){
        return repositoryService.getIdByName(name);
    }

    public String getIdByCategoryName(String categoryId){
        return categoryService.getIdByCategoryName(categoryId);
    }

    public boolean saveBatch(Collection<Material> entityList){
        return materialService.saveBatch(entityList);
    }

}
