package cn.bps.mms.service;

import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 申请单项 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationFormItemService extends IService<ApplicationFormItem> {

    void addItem(ApplicationFormItem item, String tokenValue);

    List<ApplicationItemVo> list(String tokenValue);

    void closeItems(ApplicationForm applicationForm);

    List<ApplicationFormItem> list(ApplicationForm applicationForm);
}
