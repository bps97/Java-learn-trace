package cn.bps.spring.bean.getter.factory;

import cn.bps.spring.bean.getter.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static AccountServiceImpl getAccountServiceImp(){
        return new AccountServiceImpl();
    }

}
