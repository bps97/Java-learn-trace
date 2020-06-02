package cn.bps.heam.service;



import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductInstance;
import cn.bps.heam.domain.model.template.ProductInstanceExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ProductInstanceService {

    List<Product> listProducts(List<String> productIds);

    List<Product> listProducts();

    int saveProduct(Product product);

    int updateProduct(Product product);

    long countProduct(ProductInstanceExample productExample);

    List<ProductInstance> listProductInstances(ProductInstanceExample example, RowBounds rowBounds);

    List<ProductInstance> listProductInstances(ProductInstanceExample example);

}
