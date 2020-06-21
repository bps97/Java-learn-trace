package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Application;
import cn.bps.mms.entity.ApplicationItem;
import cn.bps.mms.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 账户基本信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @PostMapping("/message")
    public Ret add(@RequestBody Application application, @RequestHeader String token){
        return Ret.ok(()->applicationService.addMessage(application, token));
    }

}

