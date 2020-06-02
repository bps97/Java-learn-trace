package cn.bps.heam.service.impl;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Sort;
import cn.bps.common.lang.util.Generator;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.*;
import cn.bps.heam.domain.model.template.ProductInstanceExample;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;
import cn.bps.heam.mapper.ProductInstanceMapper;
import cn.bps.heam.mapper.ProductMapper;
import cn.bps.heam.service.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductInstanceServiceImpl implements ProductInstanceService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductInstanceMapper productInstanceMapper;

    @Resource
    private AttributeService attributeService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ResourceUriService resourceUriService;

/**********************************************************************/








    @Override
    public List<Product> listProducts(List<String> productIds) {
        return null;
    }

    @Override
    public int saveProduct(Product product) {
        int result;
        try{
            result = productMapper.insert(product);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID;
            List<String> uuidList = listProducts().stream().map(Product::getId).collect(Collectors.toList());
            do {
                newUUID = Generator.getUUID();
            }while (uuidList.contains(newUUID));
            product.setId(newUUID);
            result = productMapper.insert(product);
        }
        return result;
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<Product> listProducts() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public Page<ProductResult> pageProducts(PageRequest pageRequest) {

        ProductInstanceExample example = new ProductInstanceExample();
        example.createCriteria().andAvailableEqualTo(true);
        example.setOrderByClause("create_time");
        return getProducts(pageRequest, example);
    }


    /* 根据分页参数、产品实例对于的Example获取产品结果集 */
    private Page<ProductResult> getProducts(PageRequest pageRequest, ProductInstanceExample example) {
        List<ProductInstance> products = productInstanceMapper.selectByExampleWithRowbounds(example, pageRequest.rowBounds());
        long elementCount = productInstanceMapper.countByExample(example);

        // product ==> productResult
        List<ProductResult> results = products.stream().map(e -> model2Result(e)).collect(Collectors.toList());

        Page<ProductResult> pageProducts = new Page<>(results);
        pageProducts.setPage(pageRequest.getPage());
        pageProducts.setSize(pageRequest.getSize());
        pageProducts.setTotalElements(elementCount);
        pageProducts.setSort(Sort.condition().orderByAsc("create_time"));

        return pageProducts;
    }

    private ProductResult model2Result(ProductInstance productInstance) {
        ProductResult result = new ProductResult();
        String imgUri = resourceUriService.getUri(productInstance.getImgUriId());
        result.setImg(imgUri);
        result.setName(productInstance.getProductName());
        result.setPrice(productInstance.getPrice());
        result.setProductId(productInstance.getProductId());
        return result;
    }

    @Override
    public Page<ProductResult> pageProducts(PageRequest pageRequest, Filter filter) {


        ProductInstanceExample example = new ProductInstanceExample();
        ProductInstanceExample.Criteria criteria = example.createCriteria().andAvailableEqualTo(true);


        Set<String> productIdSet = Sets.newHashSet();

        boolean init = false; /*表示productIdSet是否初始化--即被填充*/
        boolean classify = false;  /* 表示筛选条件是否仅有分类 默认无 */

        String categoryId = "";
        for(Filter.Property property : filter ){    /* 遍历筛选条件 */
            String value = property.getValue();
            String secondValue = property.getSecondValue();
            System.out.println(productIdSet.size());


            /* 成文规定 诸如category=value price>=<value */
            if(Objects.equals(value, Column.category.name())){
                categoryId = categoryService.getCategoryId(secondValue);
                criteria.andCategoryIdEqualTo(categoryId);
                classify = true;
                continue;
            }else{  /*属性键值对同上*/

                classify = false;
                List<ProductAttribute> attrList = Lists.newArrayList();

                if(StringUtils.isNotBlank(categoryId)){

                    /* 指定分类的属性 */
                    attrList = attributeService.listProductAttributes(categoryId);
                    Optional<String> optional = attrList.stream()
                            .filter(e->e.getAttributeName().equals(value))
                            .map(ProductAttribute::getId)
                            .findFirst();
                    String attrId = optional.get();

                    /*包含指定属性的产品*/
                    List<ProductAttributeDict> attrDictList = attributeService.listAttrDictByIdDict(attrId,secondValue);
                    Set<String> ids = attrDictList.stream()
                            .map(ProductAttributeDict::getProductId)
                            .collect(Collectors.toSet());

                    if (Boolean.FALSE.equals(init)){
                        productIdSet.addAll(ids);
                        init = true;
                    } else {
                        productIdSet.retainAll(ids);
                    }

                } else { /*如果没安排分类 那就是逻辑错误*/
                    List<ProductAttributeDict> attrDictList = attributeService.listAttrDictByDict(value,secondValue);
                    Set<String> ids = attrDictList.stream()
                            .map(ProductAttributeDict::getProductId)
                            .collect(Collectors.toSet());

                    if (Boolean.FALSE.equals(init)){
                        productIdSet.addAll(ids);
                    } else {
                        productIdSet.retainAll(ids);
                    }
                }

            }

        }
        if (Boolean.TRUE.equals(classify)){  /*如果筛选条件只有分类*/

            List<ProductInstance> onlyByCategory = productInstanceMapper.selectByExample(example);
            productIdSet.addAll(onlyByCategory.stream().map(ProductInstance::getId).collect(Collectors.toSet()));
        }
        criteria.andIdIn(Lists.newArrayList(productIdSet));
        return getProducts(pageRequest, example);
    }

    @Override
    public HomeProductResult getHomeProduct(Filter filter) {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(1);
        pageRequest.setSize(5);

        Page<ProductResult> pageProducts = pageProducts(pageRequest, filter);
        HomeProductResult homeProductResult = new HomeProductResult();
        String categoryName = filter.get(0).getSecondValue();
        homeProductResult.setCategoryName(categoryName);
        homeProductResult.setProducts(pageProducts.getContent());
        return homeProductResult;
    }
}

