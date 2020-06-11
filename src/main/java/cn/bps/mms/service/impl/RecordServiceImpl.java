package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Record;
import cn.bps.mms.mapper.RecordMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Override
    public void record(Record record) {
        String categoryId = record.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        String materialId = record.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        record.setCategoryName(categoryName);
        record.setMaterialName(categoryName);
        return;
    }
}
