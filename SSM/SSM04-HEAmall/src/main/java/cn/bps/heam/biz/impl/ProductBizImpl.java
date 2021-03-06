package cn.bps.heam.biz.impl;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Sort;
import cn.bps.common.lang.util.Generator;
import cn.bps.heam.biz.ProductBiz;
import cn.bps.heam.dict.Column;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductAttributeDict;
import cn.bps.heam.domain.model.ProductInstance;
import cn.bps.heam.domain.model.template.ProductInstanceExample;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;
import cn.bps.heam.service.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductBizImpl implements ProductBiz {

    @Resource
    private ProductInstanceService instanceService;

    @Resource
    private AttributeService attributeService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ResourceUriService resourceUriService;

    @Resource
    private ProductService productService;

    @Override
    public Page<ProductResult> pageProducts(PageRequest pageRequest) {

        ProductInstanceExample example = new ProductInstanceExample();
        example.createCriteria().andAvailableEqualTo(true);
        example.setOrderByClause("create_time");
        return getProducts(pageRequest, example);
    }

    @Override
    public Page<ProductResult> pageProducts(PageRequest pageRequest, Filter filter) {

        if(filter.isEmpty()){
            return pageProducts(pageRequest);
        }

        ProductInstanceExample example = new ProductInstanceExample();
        ProductInstanceExample.Criteria criteria = example.createCriteria().andAvailableEqualTo(true);


        Set<String> productIdSet = Sets.newHashSet();

        boolean init = false; /*表示productIdSet是否初始化--即被填充*/
        boolean classify = false;  /* 表示筛选条件是否仅有分类 默认无 */

        String categoryId = "";
        List<ProductAttribute> attrList = Lists.newArrayList(); /*指定分类的ID*/

        for(Filter.Property property : filter ){    /* 遍历筛选条件 */
            String value = property.getValue();
            String secondValue = property.getSecondValue();
            System.out.println(productIdSet.size());

            /*如果关系是EQUALS*/
            if(Objects.equals(Filter.Condition.EQUALS, property.getCondition())) {

                /* 成文规定 诸如category=value price>=<value */
                if(Objects.equals(value, Column.category.name())){
                    categoryId = categoryService.getCategoryId(secondValue);
                    criteria.andCategoryIdEqualTo(categoryId);
                    classify = true;
                    continue;
                }else{  /*属性键值对同上*/

                    classify = false;

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
            } else if(Objects.equals(Filter.Condition.CONTAINS, property.getCondition())) {


                /*如果是属性值包含xxx*/
                if(Objects.equals(value, Column.attributeValue.name())) {
                    /* 通过分类减少筛选范围 */
                    List<ProductAttributeDict> attributeDicts = Lists.newArrayList();
                    if(StringUtils.isNotBlank(categoryId)){
                        attributeDicts = attributeService.listAttrDictsByCategoryId(categoryId);
                    }else{
                        attributeService.listAttrDicts();
                    }
                    Set<String> ids = attributeDicts.stream()
                            .filter(e -> e.getAttributeValue().contains(secondValue))
                            .map(ProductAttributeDict::getProductId)
                            .collect(Collectors.toSet());

                    if (Boolean.FALSE.equals(init)){
                        productIdSet.addAll(ids);
                    } else {
                        productIdSet.retainAll(ids);
                    }
                }
                if(Objects.equals(value, Column.productName.name())) {
                    criteria.andProductNameLike("%"+secondValue+"%");
                }
            }

        }
        if (Boolean.TRUE.equals(classify)){  /*如果筛选条件只有分类*/

            List<ProductInstance> onlyByCategory = instanceService.listProductInstances(example);
            productIdSet.addAll(onlyByCategory.stream().map(ProductInstance::getId).collect(Collectors.toSet()));
        }
        if(productIdSet.isEmpty()==false){
            criteria.andIdIn(Lists.newArrayList(productIdSet));
        }
        return getProducts(pageRequest, example);
    }

    @Override
    public HomeProductResult getHomeProduct(String categoryName) {

        Filter filter = Filter.condition();
        filter.addEqualTo(Column.category.name(), categoryName);

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(1);
        pageRequest.setSize(5);

        Page<ProductResult> pageProducts = pageProducts(pageRequest, filter);
        HomeProductResult homeProductResult = new HomeProductResult();
        homeProductResult.setCategoryName(categoryName);
        homeProductResult.setProducts(pageProducts.getContent());
        return homeProductResult;
    }

    @Override
    public List<HomeProductResult> getHomeProduct(List<String> categoryNames) {
        List<HomeProductResult> homeProductResults = Lists.newArrayList();
        for(String categoryName : categoryNames){
            homeProductResults.add(getHomeProduct(categoryName));
        }
        return homeProductResults;
    }

    @Override
    public ProductResult getProduct(String id) {
        return model2Result(instanceService.getProductInstance(id));
    }

    @Override
    public void addProduct(ProductForm2 productForm) {

        Product product = new Product();
        product.setId(product.getId());
        product.setAvailable(Boolean.TRUE);


        Double  weight = productForm.getWeight();

        weight = (weight>10) ? 10F : (weight<5) ? 5 : weight;

        product.setWeight(weight);
        product.setAvailable(Boolean.TRUE);
        product.setId(Generator.getUUID());
        product.setProductName(productForm.getName());
        productService.insert(product);

    }


    /* 根据分页参数、产品实例对于的Example获取产品结果集 */
    private Page<ProductResult> getProducts(PageRequest pageRequest, ProductInstanceExample example) {
        List<ProductInstance> products = instanceService.listProductInstances(example, pageRequest.rowBounds());
        long elementCount = instanceService.countProduct(example);

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

}
