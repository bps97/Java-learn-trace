package cn.bps.mms.service;

import cn.bps.mms.model.pojo.Warehouse;
import cn.bps.mms.model.vo.KeyValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 仓库 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
public interface WarehouseService extends IService<Warehouse> {

    List<KeyValue> listAllRepoNames();

    String getIdByName(String name);

    Map<String, String> getNameIdDict();

}
