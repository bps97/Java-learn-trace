package cn.bps.mms.controller;


import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.vo.KeyValue;
import cn.bps.mms.vo.MaterialVo;
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

    @GetMapping("")
    public Ret<Page<MaterialVo>> listMaterials(PageRequest pageRequest, String categoryId, String key){
        return Ret.ok(materialService.pageMaterials(pageRequest, categoryId, key));
    }

    @GetMapping("/names")
    public Ret<List<KeyValue>> listMaterialNames(String categoryId, String repositoryId){
        return Ret.ok(materialService.listMaterialNames(categoryId, repositoryId));
    }

}

