package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.AppForm;
import cn.bps.mms.service.AppFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 申请单 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/apply")
public class AppFormController {

    @Resource
    private AppFormService appFormService;

    /**
     * 初始化申请单
     * @param appForm
     * @param token
     * @return
     */
    @PostMapping("/message")
    public Ret add(@RequestBody AppForm appForm, @RequestHeader String token){
        return Ret.ok(()-> appFormService.addMessage(appForm, token));
    }

}