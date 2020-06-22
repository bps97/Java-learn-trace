package cn.bps.mms.service.impl;

import cn.bps.mms.entity.*;
import cn.bps.mms.mapper.RecordMapper;
import cn.bps.mms.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private ApplicationFormItemService applicationFormItemService;

    @Override
    public void record(ApplicationForm applicationForm) {

        List<ApplicationFormItem> applicationFormItems = applicationFormItemService.list(applicationForm);
        List<Record> records = applicationFormItems
                .stream()
                .map(e -> generateRecord(applicationForm, e))
                .collect(Collectors.toList());
        this.saveBatch(records);
    }

    private Record generateRecord(ApplicationForm applicationForm, ApplicationFormItem item){

        Record record = new Record();
        record.setUserName(applicationForm.getUserName());
        record.setUserId(applicationForm.getUserId());
        record.setMessage(applicationForm.getMessage());
        record.setType(applicationForm.getType());

        record.setRepositoryName(item.getRepositoryName());
        record.setRepositoryId(item.getRepositoryId());
        record.setCategoryName(item.getCategoryName());
        record.setCategoryId(item.getCategoryId());
        record.setMaterialName(item.getMaterialName());
        record.setMaterialId(item.getMaterialId());
        record.setCount(item.getCount());

        return record;
    }
}
