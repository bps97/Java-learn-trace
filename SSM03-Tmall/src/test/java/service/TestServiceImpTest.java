package service;

        import cn.bps.pojo.FilterCase;
        import cn.bps.pojo.User;
        import cn.bps.service.FilterCaseServiceImp;
        import cn.bps.service.UserServiceImp;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestServiceImpTest {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    FilterCaseServiceImp filterCaseServiceImp;


    @Test
    public void userTest(){
        User user = userServiceImp.getUserByUsername("admin");

        if(user == null){
            System.out.println("???");
        }else{
            System.out.println(user.getName());
        }
    }


    @Test
    public void filterCaseTest(){
        List<FilterCase> list = filterCaseServiceImp.getFilterList();

        for(FilterCase ca:list){
            System.out.println(ca.getName());
        }
    }
}
