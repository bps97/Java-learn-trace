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
        import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestServiceImpTest {

    @Autowired
    private UserService userService;

    @Autowired
    private FilterCaseService filterCaseService;

    @Autowired
    private ConcreteFilterService concreteFilterService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBindFilterService productBindFilterService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private AdministrativeAreaService administrativeAreaService;


    @Test
    public void AdministrativeAreaTest(){

        AdministrativeArea demo = administrativeAreaService.getProvinces().get(11);

        List<AdministrativeArea> administrativeAreas = administrativeAreaService.getChildrenCities(demo.getCode());

        for(AdministrativeArea administrativeArea:administrativeAreas){
            System.out.println(administrativeArea.getName());
        }

    }


    @Test
    public void propertyTest(){

        for(Property property:propertyService.getPropertyListByCategoryId(1)){
            System.out.println(property.getName());
        }
    }



    @Test
    public void productBindFilterTest(){
//        Set<Integer> set = new HashSet<>();
//        set.add(6);
//        set.add(15);
//        Set<Integer> xx = productBindFilterService.getProductIdSet(set);
//        for(Integer i: xx){
//            System.out.println(i);
//        }


//        Set<Integer> xx = productBindFilterService.getProductIdSetByFilterId(1);
//        for(Integer i: xx){
//            System.out.print(i+" ");
//        }
//        System.out.println("");
//        Set<Integer> yy = productBindFilterService.getProductIdSetByFilterId(20);
//        for(Integer i: yy){
//            System.out.print(i+" ");
//        }
//        System.out.println("");
//        xx.retainAll(yy);
//        for(Integer i: xx){
//            System.out.print(i+" ");
//        }


        Set<Integer> productIdSet = productBindFilterService.getAllProductIdSet();
        List<Product> products = productService.rowBoundsProduct(productIdSet, 8, 8);
        for(Product product:products){
            System.out.println(product.getId()+":"+product.getName());
        }

    }


    @Test
    public void ProductImageTest(){
        Map<Integer, String> map = productImageService.getImageUrls(productService.getProductList(1, 3));
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
        List<Product> products2 = productService.getProductListByProductIdSet(productBindFilterService.getAllProductIdSet());
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
