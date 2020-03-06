package cn.bps.hea.service.impl;

import cn.bps.hea.mapper.ProductMapper;
import cn.bps.hea.domain.model.Product;
import cn.bps.hea.domain.model.ProductExample;
import cn.bps.hea.service.ProductAttributeDictService;
import cn.bps.hea.service.ProductService;
import cn.bps.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductAttributeDictService productAttributeDictService;

    @Override
    public Map<String, String> getAttributeDict(Product product) {
        return getAttributeDict(product.getId());
    }

    @Override
    public Map<String, String> getAttributeDict(String productId) {
        return productAttributeDictService.getAttributeDict(productId);
    }

    @Override
    public Product getProduct(String productId) {

        return null;
    }

    @Override
    public List<Product> getProducts(List<String> productIds) {
        return null;
    }

    @Override
    public int saveProduct(Product product) {
        int result = 0;
        try{
            result = productMapper.insert(product);
        }catch (org.springframework.dao.DuplicateKeyException e){ // 如果key重复
            String newUUID = null;
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
}
