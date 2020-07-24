package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.AppFormItem;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.mms.service.AppFormItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 申请单项 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/applyItem")
public class AppFormItemController {

    @Resource
    private AppFormItemService appFormItemService;

    /**
     * 添加申请单项
     * @param item
     * @param token
     * @return
     */
    @PostMapping("")
    public Ret add(@RequestBody AppFormItem item, @RequestHeader String token){
        return Ret.create(()-> appFormItemService.addItem(item, token));
    }

    /**
     * 获取登录用户的申请单项列表
     * @param token
     * @return
     */
    @GetMapping("")
    public Ret<List<ApplicationItemVo>> list(@RequestHeader String token){
        return Ret.ok(appFormItemService.list(token));
    }

    /**
     * 删除指定申请单项
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Ret remove(@PathVariable String id) {
        return Ret.ok(()-> appFormItemService.removeById(id));
    }

    /**
     * 批量导入物料信息
     * @param file
     * @param token
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ResponseBody
    public Ret<IPage<AppFormItem>> upload(MultipartFile file, @RequestHeader String token) throws IOException {
        return Ret.ok(appFormItemService.handleExcelStream(file, token));
    }

    /**
     * 获取分页申请单项（导入的物料表）
     * @param page
     * @param token
     * @return
     */
    @GetMapping("/list")
    public Ret<IPage<AppFormItem>> pageMaterials(Page<AppFormItem> page, @RequestHeader String token) {
        return Ret.ok(appFormItemService.pageMaterials(page,token));
    }
}

