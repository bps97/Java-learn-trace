package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.service.ApplicationFormService;
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
public class ApplicationFormController {

    @Resource
    private ApplicationFormService applicationFormService;

    /**
     * 初始化申请单
     * @param applicationForm
     * @param token
     * @return
     */
    @PostMapping("/message")
    public Ret add(@RequestBody ApplicationForm applicationForm, @RequestHeader String token){
        return Ret.ok(()-> applicationFormService.addMessage(applicationForm, token));
    }

}

