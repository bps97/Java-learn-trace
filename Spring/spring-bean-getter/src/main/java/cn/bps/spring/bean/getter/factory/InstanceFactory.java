package cn.bps.spring.bean.getter.factory;

import cn.bps.spring.bean.getter.service.IAccountService;
import cn.bps.spring.bean.getter.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
