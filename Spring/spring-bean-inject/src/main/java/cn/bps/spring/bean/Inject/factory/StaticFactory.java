package cn.bps.spring.bean.Inject.factory;

import cn.bps.spring.bean.Inject.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static AccountServiceImpl getAccountServiceImp(){
        return new AccountServiceImpl();
    }

}
