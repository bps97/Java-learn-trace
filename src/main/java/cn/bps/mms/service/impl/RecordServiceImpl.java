package cn.bps.mms.service.impl;

import cn.bps.mms.domain.ao.RecordAo;
import cn.bps.mms.entity.*;
import cn.bps.mms.mapper.RecordMapper;
import cn.bps.mms.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 记录信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private ApplicationFormItemService applicationFormItemService;

    @Resource
    private RecordMapper recordMapper;

    @Resource CategoryService categoryService;

    @Override
    public void record(ApplicationForm applicationForm) {

        List<ApplicationFormItem> applicationFormItems = applicationFormItemService.list(applicationForm);
        List<Record> records = applicationFormItems
                .stream()
                .map(e -> generateRecord(applicationForm, e))
                .collect(Collectors.toList());
        this.saveBatch(records);
    }

    @Override
    public IPage<Record> pageRecords(Page<Record> page, RecordAo ao) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        String specialLine = ao.getSpecialLines();

        String[] specialsLines = specialLine.split(",");
        HashSet<String> set = Sets.newHashSet(specialsLines);
        wrapper
                .eq("repository_id", ao.getRepositoryId())
                .in("special_line", set);
        wrapper.orderByDesc("create_time");
        return recordMapper.selectPage(page, wrapper);
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

        record.setSpecialLine(categoryService.getRootCategoryName(record.getCategoryId()));

        return record;
    }
}
