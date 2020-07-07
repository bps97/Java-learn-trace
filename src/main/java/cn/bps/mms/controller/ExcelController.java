package cn.bps.mms.controller;

import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.domain.MaterialUploadDataListener;
import cn.bps.mms.domain.MaterialEo;
import cn.bps.mms.service.UploadBiz;
import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ExcelController {

    @Resource
    private UploadBiz uploadBiz;

    @PostMapping("")
    @ResponseBody
    public Ret upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(),
                MaterialEo.class,
                new MaterialUploadDataListener(uploadBiz))
                .sheet()
                .doRead();
        return Ret.ok();
    }
}
