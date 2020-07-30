package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.mms.domain.ao.RecordAo;
import cn.bps.mms.domain.vo.RecordTreeVo;
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
import java.util.Map;
import java.util.Set;
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
    private ApplicationItemService applicationFormItemService;

    @Resource
    private RecordMapper recordMapper;

    @Resource CategoryService categoryService;

    @Override
    public void record(Application application) {

        List<ApplicationItem> applicationFormItems = applicationFormItemService.list(application);

        Record parentRecord = generateRecord(application);


        List<Record> records = applicationFormItems
                .stream()
                .map(e -> generateRecord(parentRecord, e))
                .collect(Collectors.toList());

        this.saveBatch(records);
    }



    @Override
    public IPage<RecordTreeVo> pageRecords(Page<Record> page, RecordAo ao) {

        List<Record> recordList = subRecords(ao);
        if(recordList.size() == 0){
            throw new LocalBizServiceException(CustomizeExceptionCode.RESOURCE_NOT_FOUND);
        }
        Map<String, List<Record>> parentIdMap = recordList.stream().collect(Collectors.groupingBy(Record::getParentId));
        Set<String> parentRecordIds =  parentIdMap.keySet();

        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper
                .in("id", parentRecordIds)
                .orderByDesc("update_time");

        IPage<Record> pageRecords = recordMapper.selectPage(page, wrapper);
        List vos = (List) pageRecords.getRecords()
                .stream()
                .map(e->this.model2Vo(e, parentIdMap.get(e.getId())))
                .collect(Collectors.toList());
        IPage<RecordTreeVo> iPage = pageRecords.setRecords(vos);
        return iPage;
    }

    private List<Record> subRecords(RecordAo ao) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        String specialLine = ao.getSpecialLines();
        String[] specialsLines = specialLine.split(",");
        HashSet<String> set = Sets.newHashSet(specialsLines);
        wrapper
                .isNotNull("parent_id")
                .eq("warehouse_id", ao.getWarehouseId())
                .in("special_line", set);
        wrapper.orderByDesc("create_time");

        return this.list(wrapper);
    }

    private RecordTreeVo model2Vo(Record record, List<Record> records) {
        RecordTreeVo vo = new RecordTreeVo();
        vo.setId(record.getId());
        vo.setUserName(record.getUserName());
        vo.setMessage(record.getMessage());
        vo.setType(record.getType());
        vo.setCreateTime(record.getCreateTime());
        vo.setChildren(records.stream().map(this::model2Vo).collect(Collectors.toList()));
        return vo;
    }


    private RecordTreeVo model2Vo(Record record) {
        RecordTreeVo vo = new RecordTreeVo();
        vo.setId(record.getId());
        vo.setCategoryName(record.getCategoryName());
        vo.setMaterialName(record.getMaterialName());
        vo.setWarehouseName(record.getWarehouseName());
        vo.setCount(record.getCount());
        vo.setCreateTime(record.getCreateTime());
        vo.setSpecialLine(record.getSpecialLine());
        vo.setStatus(record.getStatus());

        return vo;
    }

    private Record generateRecord(Application applicationForm) {
        Record record = new Record();
        record.setUserName(applicationForm.getUserName());
        record.setUserId(applicationForm.getUserId());
        record.setMessage(applicationForm.getMessage());
        record.setType(applicationForm.getType());
        this.save(record);
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available",true)
                .eq("user_name",record.getUserName())
                .eq("user_id",record.getUserId())
                .eq("type",record.getType())
                .orderByDesc("update_time");
        return this.getOne(wrapper,false);
    }

    private Record generateRecord(Record parent, ApplicationItem item){

        Record record = new Record();
        record.setParentId(parent.getId());

        record.setUserName(parent.getUserName());
        record.setMessage(parent.getMessage());
        record.setType(parent.getType());

        record.setWarehouseName(item.getWarehouseName());
        record.setWarehouseId(item.getWarehouseId());
        record.setCategoryName(item.getCategoryName());
        record.setCategoryId(item.getCategoryId());
        record.setMaterialName(item.getMaterialName());
        record.setMaterialId(item.getMaterialId());
        record.setCount(item.getCount());
        record.setStatus(item.getStatus());
        record.setCreateTime(item.getCreateTime());

        record.setSpecialLine(categoryService.getRootCategoryName(record.getCategoryId()));

        return record;
    }
}
