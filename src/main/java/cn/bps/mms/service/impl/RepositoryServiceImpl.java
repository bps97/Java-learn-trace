package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Repository;
import cn.bps.mms.mapper.RepositoryMapper;
import cn.bps.mms.service.RepositoryService;
import cn.bps.mms.domain.vo.KeyValue;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

/**
 * <p>
 * 仓库 服务实现类
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

    @Override
    public String getIdByName(String name) {
        QueryWrapper<Repository> wrapper = new QueryWrapper<>();
        wrapper
                .eq("name", name);
        List<Repository> repositories = this.list(wrapper);
        return repositories.isEmpty() ? null : repositories.get(0).getId();
    }

    @Override
    public Map<String, String> getNameIdDict() {
        QueryWrapper<Repository> wrapper = new QueryWrapper<>();
        return this.list(wrapper).stream()
                .collect(Collectors.toMap(Repository::getName, Repository::getId));
    }
}
