package cn.bps.mms.service;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.entity.Material;
import cn.bps.mms.vo.KeyValue;
import cn.bps.mms.vo.MaterialVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface MaterialService extends IService<Material> {

    Page<MaterialVo> pageMaterials(PageRequest pageRequest, String categoryId, String key);

    List<Material> listMaterials(String categoryId, String key);

    List<Material> listMaterials(String categoryId);

    List<KeyValue> listMaterialNames(String categoryId);
}
