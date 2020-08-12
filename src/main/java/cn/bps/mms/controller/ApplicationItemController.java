package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.model.ao.ApplicationAo;
import cn.bps.mms.model.ao.ApplicationItemAo;
import cn.bps.mms.model.ao.ApplicationType;
import cn.bps.mms.model.pojo.Application;
import cn.bps.mms.model.pojo.ApplicationItem;
import cn.bps.mms.model.vo.ApplicationItemVo;
import cn.bps.mms.service.ApplicationItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
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
@Api(tags = "申请单项")
@RestController
@RequestMapping("/applyItem")
public class ApplicationItemController {

    @Resource
    private ApplicationItemService applicationItemService;

    @ApiOperation(value = "添加申请单项")
    @PostMapping("")
    public Ret add(@RequestBody ApplicationItemAo ao, @RequestHeader String token){
        return Ret.create(()-> applicationItemService.addItem(ao, token));
    }

    @ApiOperation(value = "移除指定申请单项")
    @DeleteMapping("/{id}")
    public Ret remove(@PathVariable @Validated String id) {
        return Ret.ok(()-> applicationItemService.removeById(id));
    }

    @ApiOperation(value = "批量上传生清单列表")
    @PostMapping("/upload")
    @ResponseBody
    public Ret<IPage<ApplicationItem>> upload(MultipartFile file, @RequestHeader String token, ApplicationType applicationType) throws IOException {
        return Ret.ok(applicationItemService.handleExcelStream(file, token, applicationType.getEnum()));
    }

    @ApiOperation(value = "查询申请单列表")
    @GetMapping("")
    public Ret<List<ApplicationItemVo>> list(@RequestHeader String token, @NotEmpty ApplicationType applicationType){
        return Ret.ok(applicationItemService.list(token, applicationType.getEnum()));
    }

    @ApiOperation(value = "分页查询申请单列表")
    @GetMapping("/list")
    public Ret<IPage<ApplicationItem>> pageMaterials(Page<ApplicationItem> page, @RequestHeader String token, @NotEmpty ApplicationType applicationType) {
        return Ret.ok(applicationItemService.pageMaterials(page, token, applicationType.getEnum()));
    }

    @ApiOperation(value = "检查指定物料是否存在")
    @GetMapping("/material/check")
    public Ret checkMaterial(ApplicationItemAo ao){
        return Ret.ok(applicationItemService.checkMaterial(ao));
    }
}

