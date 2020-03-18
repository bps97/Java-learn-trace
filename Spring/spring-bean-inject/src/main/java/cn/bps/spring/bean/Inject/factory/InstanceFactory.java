package cn.bps.spring.bean.Inject.factory;

import cn.bps.spring.bean.Inject.service.IAccountService;
import cn.bps.spring.bean.Inject.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
