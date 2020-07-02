package cn.bps.mms.service.impl;

import cn.bps.common.lang.CustomizeExceptionCode;
import cn.bps.common.lang.LocalBizServiceException;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.util.EncryptUtils;
import cn.bps.mms.domain.vo.AccountVo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.mapper.AccountMapper;
import cn.bps.mms.service.AccountService;
import cn.bps.mms.service.RoleService;
import cn.bps.security.server.service.TokenService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private TokenService tokenService;

    @Resource
    private RoleService roleService;

    @Override
    public Token login(Account loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Account account = getByUsername(username);
        if(Objects.isNull(account)) {  /*如果该账户不存在*/
            throw new LocalBizServiceException(CustomizeExceptionCode.ACCOUNT_NOT_EXIST, username);
        }else{
            String md5Password = EncryptUtils.md5Encrypt(password);
            if(Objects.equals(md5Password, account.getPassword())) {
                Token xx = tokenService.getAccessTokenByUser(username);
                return xx;
            }else { /*密码错误*/
                throw new LocalBizServiceException(CustomizeExceptionCode.PASSWORD_NOT_INCORRECT, username);
            }
        }
    }

    @Override
    public void register(Account regForm) {
        String username = regForm.getUsername();
        Account account = getByUsername(username);
        if(Objects.nonNull(account)){
            // 这里需要写一个注册失败相关的返回对象  划掉 不写了 下面抛异常
            throw new LocalBizServiceException(CustomizeExceptionCode.NAME_ALREADY_EXIST, regForm.getUsername());
        } else {
            String md5Password = EncryptUtils.md5Encrypt(regForm.getPassword()); // 加密密码
            account = regForm;
            account.setPassword(md5Password);
            account.setRoleId(roleService.getDefaultRoleId());
            this.save(account);
        }
    }

    @Override
    public Account getByUsername(String username) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("username", username);

        return this.getOne(wrapper);
    }

    @Override
    public IPage<AccountVo> pageUsers(Page<Account> page, String key) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        if(key.isEmpty() == false){
            wrapper
                    .like("name", key)
                    .or().like("username",key);
        }
        IPage<Account> pageAccounts = this.page(page, wrapper);
        List vos = (List) pageAccounts.getRecords()
                .stream()
                .map(this::model2Vo).collect(Collectors.toList());
        IPage<AccountVo> iPage = pageAccounts.setRecords(vos);
        return iPage;
    }

    @Override
    public void changeAvailable(String id, Boolean available) {
        Account account = new Account();
        account.setId(id);
        account.setAvailable(available);
        if(this.updateById(account) == false){
            throw new LocalBizServiceException(CustomizeExceptionCode.UPDATE_FAIL);
        }
    }

    @Override
    public void updateById(String id, Account account) {
        account.setId(id);
        updateById(account);
    }

    @Override
    public void changeRoleId(String id, String roleId) {
        Account account = new Account();
        account.setId(id);
        account.setRoleId(roleId);
        updateById(account);
    }

    private AccountVo model2Vo(Account account){
        AccountVo vo = new AccountVo();
        vo.setId(account.getId());
        vo.setAvailable(account.getAvailable());
        vo.setCreateTime(account.getCreateTime());
        vo.setUpdateTime(account.getUpdateTime());
        vo.setEmail(account.getEmail());
        vo.setMobile(account.getMobile());
        vo.setName(account.getName());
        vo.setUsername(account.getUsername());
        vo.setPassword(account.getPassword());
        String roleName = roleService.getRoleName(account.getRoleId());
        vo.setRoleName(roleName);
        return vo;
    }

    private AccountVo model2Vo(Object obj){
        obj = (Account)obj;
        return model2Vo(obj);
    }

}
