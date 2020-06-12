package cn.bps.mms.controller;


import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.Record;
import cn.bps.mms.service.RecordService;
import cn.bps.security.server.service.TokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 账户基本信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    @Resource
    private TokenService tokenService;

    @PostMapping("")
    public Ret add(@RequestBody Record record, @RequestHeader String token){
//        tokenService.parse(token);
        return Ret.create(()->recordService.record(record));
    }

}

