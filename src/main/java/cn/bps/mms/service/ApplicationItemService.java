package cn.bps.mms.service;

import cn.bps.mms.entity.Application;
import cn.bps.mms.entity.ApplicationItem;
import cn.bps.mms.vo.ApplicationItemVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 账户基本信息 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationItemService extends IService<ApplicationItem> {

    void addItem(ApplicationItem item, String tokenValue);

    List<ApplicationItemVo> list(String tokenValue);

    void closeItems(Application aplication);
}
