package cn.bps.heam.service.impl;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Sort;
import cn.bps.heam.dict.Column;
import cn.bps.common.lang.api.Filter;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.*;
import cn.bps.heam.mapper.ProductMapper;
import cn.bps.heam.service.ProductAttributeDictService;
import cn.bps.heam.service.ProductAttributeService;
import cn.bps.heam.service.ProductCategoryService;
import cn.bps.heam.service.ProductService;
import cn.bps.common.lang.util.Generator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductAttributeDictService attributeDictService;

    @Resource
    private ProductAttributeService attributeService;

    @Resource
    private ProductCategoryService categoryService;

/**********************************************************************/



    @Override
    public Map<String, String> getAttributeDict(Product product) {
        return getAttributeDict(product.getId());
    }

    @Override
    public Map<String, String> getAttributeDict(String productId) {
        return attributeDictService.getAttributeDict(productId);
    }

    @Override
    public List<String> listAttributes(String productId) {
        listAttributes(getProduct(productId));
        return null;
    }

    @Override
    public List<String> listAttributes(Product product) {
        return  attributeService.listProductAttributes(product.getCategoryId())
                .stream().map(ProductAttribute::getAttributeName).collect(Collectors.toList());
    }

    @Override
    public Product getProduct(String productId) {

        return null;
    }

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
    public Page<Product> pageProducts(PageRequest pageRequest) {

        ProductExample example = new ProductExample();
        example.createCriteria().andAvailableEqualTo(true);
        example.setOrderByClause("create_time");
        return getProducts(pageRequest, example);
    }

    private Page<Product> getProducts(PageRequest pageRequest, ProductExample example) {
        List<Product> products = productMapper.selectByExampleWithRowbounds(example, pageRequest.rowBounds());
        long elementCount = productMapper.countByExample(example);
        Page<Product> pageProducts = new Page<>(products);
        pageProducts.setPage(pageRequest.getPage());
        pageProducts.setSize(pageRequest.getSize());
        pageProducts.setTotalElements(elementCount);
        pageProducts.setSort(Sort.condition().orderByAsc("create_time"));

        return pageProducts;
    }

    @Override
    public Page<Product> pageProducts(PageRequest pageRequest, Filter filter) {


        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria().andAvailableEqualTo(true);


        Set<String> productIdSet = Sets.newHashSet();
        boolean init = false; /*表示productIdSet是否初始化--即被填充*/
        String categoryId = "";
        for(Filter.Property property : filter ){
            String value = property.getValue();
            String secondValue = property.getSecondValue();
            System.out.println(productIdSet.size());


            /* 成文规定 诸如category=value price>=<value */
            if(Objects.equals(value, Column.category.name())){
                categoryId = categoryService.getId(secondValue);
                criteria.andCategoryIdEqualTo(categoryId);
                continue;
            }else{  /*属性键值对同上*/

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
                    List<ProductAttributeDict> attrDictList = attributeDictService.listAttrDictByIdDict(attrId,secondValue);
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
                    List<ProductAttributeDict> attrDictList = attributeDictService.listAttrDictByDict(value,secondValue);
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
        criteria.andIdIn(Lists.newArrayList(productIdSet));
        return getProducts(pageRequest, example);
    }
}

