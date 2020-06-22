package cn.bps.mms.service;

import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账户基本信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
public interface RecordService extends IService<Record> {

    void record(ApplicationForm applicationForm);
}
