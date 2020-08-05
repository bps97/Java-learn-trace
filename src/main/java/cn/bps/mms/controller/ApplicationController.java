package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.ApplicationAo;
import cn.bps.mms.service.ApplicationService;
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
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    /**
     * 初始化申请单
     * @param ao
     * @param token
     * @return
     */
    @PostMapping("/message")
    public Ret add(@RequestBody ApplicationAo ao, @RequestHeader String token){
        return Ret.ok(()-> applicationService.addMessage(ao, token));
    }

    @PutMapping("/message")
    public Ret update(@RequestBody ApplicationAo ao, @RequestHeader String token){
        return Ret.ok(()-> applicationService.addMessage(ao, token));
    }

}