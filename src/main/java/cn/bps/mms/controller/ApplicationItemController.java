package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.ApplicationItem;
import cn.bps.mms.service.ApplicationItemService;
import cn.bps.mms.vo.ApplicationItemVo;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账户基本信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/applicationItem")
public class ApplicationItemController {

    @Resource
    private ApplicationItemService applicationItemService;

    @PostMapping("")
    public Ret add(@RequestBody ApplicationItem item, @RequestHeader String token){
        return Ret.create(()->applicationItemService.addItem(item, token));
    }

    @GetMapping("")
    public Ret<List<ApplicationItemVo>> list(@RequestHeader String token){
        return Ret.ok(applicationItemService.list(token));
    }
}

