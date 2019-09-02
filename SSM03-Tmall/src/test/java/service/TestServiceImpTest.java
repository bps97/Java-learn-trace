package service;

        import cn.bps.pojo.ConcreteFilter;
        import cn.bps.pojo.FilterCase;
        import cn.bps.pojo.Product;
        import cn.bps.pojo.User;
        import cn.bps.service.*;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.List;
        import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestServiceImpTest {

    @Autowired
    UserService userService;

    @Autowired
    FilterCaseService filterCaseService;

    @Autowired
    ConcreteFilterService concreteFilterService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductBindFilterService productBindFilterService;


    @Test
    public void ProductTest(){
        List<Product> products = productService.getProductList(1, 3);
        for(Product product: products){
            System.out.println(product.getId());

        }

        System.out.println("-------------------");
        List<Product> products2 = productService.getProductListByFilter(productBindFilterService.getProductIdSet());
        for(Product product: products){
            System.out.println(product.getId());

        }
    }


    @Test
    public void userTest(){
        User user = userService.getUserByUsername("admin");

        if(user == null){
            System.out.println("???");
        }else{
            System.out.println(user.getName());
        }
    }


    @Test
    public void ConcreteFilterTest(){
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap();
        for (ConcreteFilter con : map.get(1)){
            System.out.println(con.getValue());
        }
    }

    @Test
    public void filterCaseTest(){
        List<FilterCase> list = filterCaseService.getFilterList();

        for(FilterCase ca:list){
            System.out.println(ca.getName());
        }
    }
}
