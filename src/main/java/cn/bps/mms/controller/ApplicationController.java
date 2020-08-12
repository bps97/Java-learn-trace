package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.ApplicationAo;
import cn.bps.mms.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "申请单")
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
    @ApiOperation(value = "添加申请单", notes = "最好补充message字段")
    @PutMapping("/message")
    public Ret update(@RequestBody ApplicationAo ao, @RequestHeader String token){
        return Ret.ok(()-> applicationService.addMessage(ao, token));
    }

}