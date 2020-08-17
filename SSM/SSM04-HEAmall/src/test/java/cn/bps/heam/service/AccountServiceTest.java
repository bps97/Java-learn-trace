package cn.bps.heam.service;


import cn.bps.heam.biz.UserBiz;
import cn.bps.heam.domain.form.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Resource
    private UserBiz userBiz;


    @Test
    public void regTest(){

        userBiz.userRegister(new UserForm());

    }

}



