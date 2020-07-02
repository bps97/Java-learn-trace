package cn.bps.mms.service;

import cn.bps.mms.domain.ao.MaterialAo;
import cn.bps.mms.entity.Material;
import cn.bps.mms.domain.vo.KeyValue;
import cn.bps.mms.domain.vo.MaterialVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 物料 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface MaterialService extends IService<Material> {


    List<Material> listMaterials(String categoryId);

    List<Material> listMaterialsByRepositoryId(String repositoryId);

    List<Material> listMaterialsByRepositoryId(String categoryId, String repositoryId);

    List<KeyValue> listMaterialNames(String categoryId, String repositoryId);

    IPage<MaterialVo> pageMaterials(Page<Material> page, MaterialAo ao);

    void saveMaterial(Material material);

    void updateById(String id, Material material);
}
