package cn.bps.service;

import cn.bps.mapper.ProductMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductExample;
import cn.bps.pojo.ProductItem;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getProductList(int start, int step) {
        ProductExample productExample = new ProductExample();
        RowBounds rowBounds = new RowBounds(start-1,step);
        return productMapper.selectByExampleWithRowbounds(productExample,rowBounds);

    }

	@Override
    public List<Product> getProductListByProductIdSet(Set<Integer> set) {
        ProductExample productExample = new ProductExample();

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set));
            return productMapper.selectByExample(productExample);

        }
        return new ArrayList<>();
    }

	@Override
    public List<Product> rowBoundsProduct(Set<Integer> set, Integer start, Integer step ) {
        return rowBoundsProduct(set,start,step,false);  //默认不可见
    }

    //重载实现参数默认值
    @Override
    public List<Product> rowBoundsProduct(Set<Integer> set, Integer start, Integer step, boolean visual) {

        ProductExample productExample = new ProductExample();

        int flag = (visual)?99:1;//可见时，查看所有非下架商品

        RowBounds rowBounds = new RowBounds(start,step);

        if (set.size() > 0) {
            productExample.createCriteria().andIdIn(new ArrayList(set)).andUndercarriageNotEqualTo(flag);
            List<Product> products = productMapper.selectByExampleWithRowbounds(productExample, rowBounds);
            return products;

        }
        return new ArrayList<>();
    }

	@Override
    public Product getProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

	@Override
    public int deleteOneById(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

	@Override
    public int insertOne(Product product) {
        return productMapper.insert(product);
    }

	@Override
    public int updateOne(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

	@Override
    public Product editOne(Product product) {

        Product newProduct = clone(product);
        if(undercarriage(product) > 0){//如果下架成功
            if(insertOne(newProduct) > 0){//如果更新成果


                return newProduct;
            }
            undercarriage(product);//重新上架
            return null;
        }


        return null;
    }

	@Override
    public int getRecentProductId(Product product) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andCategory_idEqualTo(product.getCategory_id()).andSub_titleEqualTo(product.getSub_title());
        productExample.setOrderByClause("`id` DESC");

        List<Product> products = productMapper.selectByExample(productExample);
        if(products.size()>0)
            return products.get(0).getId();
        return 0;
    }

	@Override
    public Set<Integer> getProductIDSetByProductName(String name) {

        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andNameLike("%"+name+"%");
        List<Product> products = productMapper.selectByExample(productExample);
        Set<Integer> productIdSet = new HashSet<>();
        for(Product product: products){
            productIdSet.add(product.getId());
        }

        return productIdSet;
    }

	@Override
    public Map<Integer, Product> getProductMapByShoppingCartList(List<ProductItem> shoppingCarts) {

        Map<Integer, Product> map = new HashMap<>();

        for(ProductItem shoppingCart : shoppingCarts){
            map.put(shoppingCart.getProduct_id(),productMapper.selectByPrimaryKey(shoppingCart.getProduct_id()));
        }

        return map;
    }

	@Override
    public Product clone(Product product) {

        Product newProduct = new Product();
        newProduct.setUndercarriage(product.getUndercarriage());
        newProduct.setCategory_id(product.getCategory_id());
        newProduct.setPrice(product.getPrice());
        newProduct.setSale(product.getSale());
        newProduct.setName(product.getName());
        newProduct.setStock(product.getStock());
        newProduct.setSub_title(product.getSub_title());

        return newProduct;
    }

	@Override
    public int undercarriage(Product product) {
        int flag = (product.getUndercarriage()==0)?1:0;
        product.setUndercarriage(flag);
        return productMapper.updateByPrimaryKey(product);
    }


}
