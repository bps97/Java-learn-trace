package service;

        import cn.bps.pojo.User;
        import cn.bps.service.UserServiceImp;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceImpTest {

    @Autowired
    UserServiceImp userServiceImp;


    @Test
    public void test(){
        User user = userServiceImp.getUserByUsername("admin");

        if(user == null){
            System.out.println("???");
        }else{
            System.out.println(user.getName());
        }
    }

}
