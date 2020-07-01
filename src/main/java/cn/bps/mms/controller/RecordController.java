package cn.bps.mms.controller;

import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.ao.RecordAo;
import cn.bps.mms.entity.Record;
import cn.bps.mms.service.RecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("")
    public Ret<IPage<Record>> pageRecords(Page<Record> page,
                                          RecordAo ao){
        return Ret.ok(recordService.pageRecords(page,ao));
    }




}

