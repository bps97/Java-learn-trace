package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Repository;
import cn.bps.mms.mapper.RepositoryMapper;
import cn.bps.mms.service.RepositoryService;
import cn.bps.mms.domain.vo.KeyValue;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class RepositoryServiceImpl extends ServiceImpl<RepositoryMapper, Repository> implements RepositoryService {

    @Override
    public List<KeyValue> listAllRepoNames() {
        return this.list().stream().map(e->{
            KeyValue keyValue = new KeyValue();
            keyValue.setValue(e.getName());
            keyValue.setKey(e.getId());
            return keyValue;
        }).collect(Collectors.toList());
    }
}
