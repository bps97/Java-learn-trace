package cn.bps.mms.service;

import cn.bps.mms.model.ao.MaterialAo;
import cn.bps.mms.model.pojo.Material;
import cn.bps.mms.model.vo.KeyValue;
import cn.bps.mms.model.vo.MaterialVo;
import cn.bps.mms.model.pojo.Record;
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

    List<Material> listMaterialsByWarehouseId(String warehouseId);

    List<Material> listMaterialsByWarehouseId(String categoryId, String warehouseId);

    List<KeyValue> listMaterialNames(String categoryId, String warehouseId, String status);

    List<Material> listMaterial(String categoryId, String warehouseId, String status);

    IPage<MaterialVo> pageMaterials(Page<Material> page, MaterialAo ao);

    String getIdByName(String materialName);

    void saveMaterial(Material material);

    void updateById(String id, Material material);

    MaterialVo getVoById(String id);

    Material validateExist(Material material);

    Material getOneByKey(String materialName, String warehouseId, String status);

    List<Record> getRecords(String id);

}
