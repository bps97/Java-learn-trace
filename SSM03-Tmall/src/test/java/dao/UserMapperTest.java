package dao;

import cn.bps.mapper.UserMapper;
import cn.bps.pojo.User;
import cn.bps.pojo.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo("admin");
        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);
        if(user == null){
            System.out.println("??");
        }else{
            System.out.println(user.getName());
        }
        System.out.println(userMapper.selectByPrimaryKey(1).getName());
    }
}
