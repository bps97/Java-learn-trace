package cn.bps.heam.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.heam.biz.AttributeBiz;
import cn.bps.heam.domain.form.AttributeForm;
import cn.bps.heam.domain.result.AttributeTupleResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/attrs")
public class AttributeController {

    @Resource
    private AttributeBiz attributeBiz;

    @GetMapping("/category/{categoryId}")
    public Ret<AttributeTupleResult> listAttributes(@PathVariable String categoryId){
        return Ret.ok(attributeBiz.tupleAttributes(categoryId));
    }

    @PostMapping("/")
    public Ret addAttribute(AttributeForm attributeForm){
        return Ret.create(()->{});
    }

}
