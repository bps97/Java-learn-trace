package cn.bps.heam.service;


import cn.bps.heam.domain.form.UserForm;
import cn.bps.common.lang.domain.Success;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Resource
    private AccountService accountService;


    @Test
    public void regTest(){

        Success success = accountService.userRegister(new UserForm());

    }

}



