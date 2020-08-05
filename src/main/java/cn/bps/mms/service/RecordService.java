package cn.bps.mms.service;

import cn.bps.mms.model.ao.RecordAo;
import cn.bps.mms.model.vo.RecordTreeVo;
import cn.bps.mms.model.pojo.Application;
import cn.bps.mms.model.pojo.Record;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 记录信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
public interface RecordService extends IService<Record> {

    void record(Application application);

    IPage<RecordTreeVo> pageRecords(Page<Record> page, RecordAo ao);

    List<Record> listRecords(String materialId);
}
