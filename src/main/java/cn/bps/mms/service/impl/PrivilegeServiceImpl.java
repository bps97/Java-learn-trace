package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Privilege;
import cn.bps.mms.mapper.PrivilegeMapper;
import cn.bps.mms.service.PrivilegeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-07-01
 */
@Service
public class PrivilegeServiceImpl extends ServiceImpl<PrivilegeMapper, Privilege> implements PrivilegeService {

    @Override
    public List<Privilege> listPrivileges() {
        QueryWrapper<Privilege> wrapper = new QueryWrapper<>();
        wrapper.eq("available",true);
        return this.list(wrapper);
    }
}
