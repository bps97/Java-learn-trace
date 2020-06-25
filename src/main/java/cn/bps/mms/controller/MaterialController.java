package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.domian.ao.MaterialAo;
import cn.bps.mms.entity.Material;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.domian.vo.KeyValue;
import cn.bps.mms.domian.vo.MaterialVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 产品 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Resource
    private MaterialService materialService;

    /**
     * 分页获取物料数据
     * @param page
     * @param ao
     * @return
     */
    @GetMapping("")
    public Ret<IPage<MaterialVo>> pageMaterials(Page<Material> page, MaterialAo ao){
        return Ret.ok(materialService.pageMaterials(page, ao));
    }

    /**
     * 获取物料名称列表
     * @param categoryId
     * @param repositoryId
     * @return
     */
    @GetMapping("/names")
    public Ret<List<KeyValue>> listMaterialNames(String categoryId, String repositoryId){
        return Ret.ok(materialService.listMaterialNames(categoryId, repositoryId));
    }

}

