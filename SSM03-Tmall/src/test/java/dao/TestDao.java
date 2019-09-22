//package dao;
//
//
//import cn.bps.mapper.*;
//import cn.bps.pojo.*;
//import org.apache.ibatis.session.RowBounds;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.security.PublicKey;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
//public class TestDao {
//
//    @Autowired
//    private SubCategoryMapper subCategoryMapper;
//
//    @Autowired
//    private CategoryMapper categoryMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private LabelCategoryMapper labelCategoryMapper;
//
//    @Autowired
//    private ProductBindFilterMapper productBindFilterMapper;
//
//    @Autowired
//    private ProductMapper productMapper;
//
//
//    @Autowired
//    private AdministrativeAreaMapper administrativeAreaMapper;
//
//
//    @Test
//    public void AdministrativeAreaTest(){
//        AdministrativeAreaExample administrativeAreaExample = new AdministrativeAreaExample();
//        administrativeAreaExample.createCriteria().andLevel_typeEqualTo(1);
//        List<AdministrativeArea> administrativeAreas = administrativeAreaMapper.selectByExample(administrativeAreaExample);
//
//        for(AdministrativeArea administrativeArea:administrativeAreas){
//            System.out.println(administrativeArea.getName());
//        }
//
//
//    }
//
//
//    @Test
//    public void ProductTest(){
//        ProductExample productExample = new ProductExample();
//        RowBounds rowBounds = new RowBounds(0,2);
//        List<Product> products = productMapper.selectByExampleWithRowbounds(productExample, rowBounds);
//
//        for(Product product:products){
//            System.out.println(product.getId()+":"+product.getName());
//        }
//    }
//
//
//    @Test
//    public void productBindFilterTest(){
//        ProductBindFilterExample productBindFilterExample = new ProductBindFilterExample();
//        List<ProductBindFilter> productBindFilter = productBindFilterMapper.selectByExample(productBindFilterExample);
//        Set<Integer> productIdSet = new HashSet();
//        for(ProductBindFilter pbf:productBindFilter){
//            productIdSet.add(pbf.getProduct_id());
//        }
//
//        System.out.println(productIdSet);
//
//
//
//    }
//
//
//
//
//    @Test
//    public void labelCategoryTest(){
//        LabelCategoryExample filterExample = new LabelCategoryExample();
//        filterExample.setOrderByClause("`id` DESC");
//        List<LabelCategory> list = labelCategoryMapper.selectByExample(filterExample);
//
//        for(LabelCategory ca:list){
//            System.out.println(ca.getName()+":"+ca.getId());
//        }
//    }
//
//
//
//    @Test
//    public void subCategoryTest(){
//
//        Category category = new Category();
//        category.setId(15);
//        SubCategoryExample subCategoryExample = new SubCategoryExample();
//        subCategoryExample.createCriteria().andCategoryIdEqualTo(category.getId());
//        List<SubCategory> list = subCategoryMapper.selectByExample(subCategoryExample);
//        System.out.println(list.toArray().toString());
//    }
//
//
//    @Test
//    public void categoryTest(){
//        CategoryExample categoryExample = new CategoryExample();
//        long gourpNumber = categoryMapper.countByExample(categoryExample);
//        List<List<Category>> lists = new ArrayList<List<Category>>();
//        List<Category> categories = categoryMapper.selectByExample(categoryExample);
//        int start = 1;
//        List<Category> list = new ArrayList<>();
//
//
//
//
//        for(Category category:categories){
//
//            if(category.getGroup_id() == start && start <= gourpNumber){
//                list.add(category);
//            }else {
//
//                List<Category> temp = new ArrayList<>(list);
//                lists.add(temp);
//                list.clear();
//                list.add(category);
//                ++start;
//            }
//
//        }
//
//    }
//
//
//    @Test
//    public void userTest(){
//        UserExample userExample = new UserExample();
//        userExample.createCriteria().andNameEqualTo("admin");
//        User user = (userMapper.selectByExample(userExample).isEmpty())?null:userMapper.selectByExample(userExample).get(0);
//        if(user == null){
//            System.out.println("??");
//        }else{
//            System.out.println(user.getName());
//        }
//        System.out.println(userMapper.selectByPrimaryKey(1).getName());
//    }
//
//}
