package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.ApplicationAo;
import cn.bps.mms.model.ao.ApplicationItemAo;
import cn.bps.mms.model.pojo.Application;
import cn.bps.mms.model.pojo.ApplicationItem;
import cn.bps.mms.model.vo.ApplicationItemVo;
import cn.bps.mms.service.ApplicationItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
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
public class ApplicationItemController {

    @Resource
    private ApplicationItemService applicationItemService;

    /**
     * 添加申请单项
     * @param ao
     * @param token
     * @return
     */
    @PostMapping("")
    public Ret add(@RequestBody ApplicationItemAo ao, @RequestHeader String token){
        return Ret.create(()-> applicationItemService.addItem(ao, token));
    }


    /**
     * 删除指定申请单项
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Ret remove(@PathVariable String id) {
        return Ret.ok(()-> applicationItemService.removeById(id));
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
    public Ret<IPage<ApplicationItem>> upload(MultipartFile file, @RequestHeader String token, Application form) throws IOException {
        return Ret.ok(applicationItemService.handleExcelStream(file, token, form));
    }


    /**
     * 获取登录用户的申请单项列表
     * @param token
     * @return
     */
    @GetMapping("")
    public Ret<List<ApplicationItemVo>> list(@RequestHeader String token, @NotEmpty ApplicationAo applicationAo){
        return Ret.ok(applicationItemService.list(token, applicationAo.getEnum()));
    }

    /**
     * 获取分页申请单项（导入的物料表）
     * @param page
     * @param token
     * @return
     */
    @GetMapping("/list")
    public Ret<IPage<ApplicationItem>> pageMaterials(Page<ApplicationItem> page, @RequestHeader String token, @NotEmpty ApplicationAo applicationAo) {
        return Ret.ok(applicationItemService.pageMaterials(page, token, applicationAo.getEnum()));
    }

    /**
     * 检查是否有对应物料，没有则创建
     * @param ao
     * @return
     */
    @GetMapping("/material/check")
    public Ret checkMaterial(ApplicationItemAo ao){
        return Ret.ok(applicationItemService.checkMaterial(ao));
    }
}

