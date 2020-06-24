package cn.bps.mms.service;

import cn.bps.mms.entity.Repository;
import cn.bps.mms.domian.vo.KeyValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 收货地址 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface RepositoryService extends IService<Repository> {

    List<KeyValue> listAllRepoNames();
}
