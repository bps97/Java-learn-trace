package cn.bps.service.impl;

import cn.bps.service.IAccountService;
import org.springframework.stereotype.Service;


@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
        try {
            int i = 1/0;
        }catch (Exception e){
            throw e;
        }finally {
            ;
        }
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了["+i+"]");
    }

    @Override
    public int removeAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
