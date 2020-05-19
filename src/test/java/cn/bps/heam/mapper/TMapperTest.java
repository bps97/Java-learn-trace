package cn.bps.heam.mapper;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Sort;
import cn.bps.heam.SsmApplication;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.*;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsmApplication.class)
@EnableAutoConfiguration
public class TMapperTest {

    @Resource
    private ProductCategoryMapper categoryMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource AuthenticationMapper authenticationMapper;

    @Test
    public void authenticationTest(){
        long xx = authenticationMapper.countByExample(new AuthenticationExample());
        authenticationMapper.selectByExample(new AuthenticationExample());
        System.out.println(xx);
    }

    @Test
    public void categoryTest(){

        ProductCategoryExample categoryExample = new ProductCategoryExample();
        List<ProductCategory> categories = categoryMapper.selectByExample(categoryExample);
        for(ProductCategory category : categories){
            System.out.println(category.getCategoryName());
        }

        System.out.println(categories.size());
        System.out.println(JSON.toJSONString(categories));

    }

    @Test
    public void pageProductTest(){
        PageRequest request = new PageRequest(1,2); /* 第一页,页大小为1*/
        ProductExample example = new ProductExample();
        example.setOrderByClause("create_time");
        List<Product> products = productMapper.selectByExampleWithRowbounds(example, request.rowBounds());
        Page<Product> pageProducts = new Page<>(products);
        pageProducts.setSort(Sort.condition().orderByCreateTimeAsc());
        System.out.println(JSON.toJSONString(pageProducts));
    }


}
