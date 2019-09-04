package service;

        import cn.bps.pojo.*;
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

    @Autowired
    ProductImageService productImageService;


    @Test
    public void ProductImageTest(){
        Map<Integer, String> map = productImageService.getImageUrl(productService.getProductList(1, 3));
        for(String url:map.values()){
            System.out.println(url);
        }
    }


    @Test
    public void ProductTest(){
        List<Product> products = productService.getProductList(1, 3);
        for(Product product: products){
            System.out.println(product.getId());

        }

        System.out.println("-------------------");
        List<Product> products2 = productService.getProductListByFilter(productBindFilterService.getProductIdSet(null));
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
        List<Integer> list = filterCaseService.getFilterIdList();
        Map<Integer, List<ConcreteFilter>> map = concreteFilterService.getFilterMap(list);
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
