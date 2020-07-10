package cn.bps.mms.service;

import cn.bps.mms.entity.Repository;
import cn.bps.mms.domain.vo.KeyValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 仓库 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface RepositoryService extends IService<Repository> {

    List<KeyValue> listAllRepoNames();

    String getIdByName(String name);

    Map<String, String> getNameIdDict();

}
