package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.MaterialAo;
import cn.bps.mms.model.ao.MaterialParams;
import cn.bps.mms.model.pojo.Material;
import cn.bps.mms.model.pojo.Record;
import cn.bps.mms.model.vo.RecordVo;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.model.vo.KeyValue;
import cn.bps.mms.model.vo.MaterialVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 物料 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Api(tags = "物料管理")
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Resource
    private MaterialService materialService;

    /**
     * 分页获取物料数据
     * @param page
     * @param params
     * @return
     */
    @GetMapping("")
    public Ret<IPage<MaterialVo>> pageMaterials(Page<Material> page, MaterialParams params){
        return Ret.ok(materialService.pageMaterials(page, params));
    }

    /**
     * 获取物料名称列表
     * @param categoryId
     * @param warehouseId
     * @return
     */
    @GetMapping("/names")
    public Ret<List<KeyValue>> listMaterialNames(String categoryId, String warehouseId, String status){
        return Ret.ok(materialService.listMaterialNames(categoryId, warehouseId, status));
    }


    @GetMapping("/options")
    public Ret<List<Material>> listMaterials(String categoryId, String warehouseId, String status){
        return Ret.ok(materialService.listMaterial(categoryId, warehouseId, status));
    }

    /**
     * 添加物料信息
     * @param material
     * @return
     */
    @PostMapping("/add")
    public Ret<Object> add(@RequestBody Material material){
        return Ret.create(()->materialService.saveMaterial(material));
    }

    /**
     * 移除指定实例
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Ret<Boolean> remove(@PathVariable String id) {
        return Ret.ok(()->materialService.removeById(id));
    }

    /**
     * 修改指定实例
     * @param id
     * @param ao
     * @return
     */
    @PutMapping("/{id}")
    public Ret modify(@PathVariable String id, @RequestBody MaterialAo ao) {
        return Ret.ok(()->materialService.updateById(id, ao));
    }

    /**
     * 获取指定物料
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Ret get(@PathVariable String id) {
        return Ret.ok(materialService.getVoById(id));
    }

    /**
     * 获取指定物料的使用记录
     * @param id
     * @return
     */
    @GetMapping("/{id}/logs")
    public Ret<List<RecordVo>> listRecords(@PathVariable String id) {
        return Ret.ok(materialService.getRecords(id));
    }
}

