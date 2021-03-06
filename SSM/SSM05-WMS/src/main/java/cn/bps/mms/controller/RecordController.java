package cn.bps.mms.controller;

import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.RecordAo;
import cn.bps.mms.model.vo.RecordTreeVo;
import cn.bps.mms.model.pojo.Record;
import cn.bps.mms.service.RecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 记录信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@Api(tags = "日志记录管理")
@RestController
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    /**
     * 分页获取记录列表
     * @param page
     * @param ao
     * @return
     */
    @GetMapping("")
    public Ret<IPage<RecordTreeVo>> pageRecords(Page<Record> page, RecordAo ao){
        return Ret.ok(recordService.pageRecords(page, ao));
    }
}

