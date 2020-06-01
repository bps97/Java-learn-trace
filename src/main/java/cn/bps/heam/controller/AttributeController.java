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

    @PostMapping("/category/{categoryId}")
    public Ret addAttribute(@PathVariable String categoryId, @RequestBody AttributeForm attributeForm){
        attributeForm.setCategoryId(categoryId);
        return Ret.create(()->{attributeBiz.saveAttribute(attributeForm);});
    }

    @DeleteMapping("/{id}")
    public Ret removeAttribute(@PathVariable String id){
        return Ret.ok(()->attributeBiz.removeAttribute(id));
    }

    @PutMapping("/{id}")
    public Ret updateAttribute(@PathVariable String id, @RequestBody AttributeForm attributeForm){
        attributeForm.setId(id);
        return Ret.ok(()->attributeBiz.updateAttribute(attributeForm));
    }

    @GetMapping("/{id}")
    public Ret queryAttribute(@PathVariable String id){
        return Ret.ok(attributeBiz.queryAttributeById(id));
    }

}
