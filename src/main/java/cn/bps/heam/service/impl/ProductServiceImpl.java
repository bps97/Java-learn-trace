package cn.bps.heam.service.impl;

import cn.bps.heam.domain.model.Product;
import cn.bps.heam.domain.model.ProductAttribute;
import cn.bps.heam.domain.model.ProductExample;
import cn.bps.heam.mapper.ProductMapper;
import cn.bps.heam.service.ProductAttributeDictService;
import cn.bps.heam.service.ProductAttributeService;
import cn.bps.heam.service.ProductService;
import cn.bps.heam.util.UtilGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductAttributeDictService attributeDictService;

    @Resource
    private ProductAttributeService attributeService;

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
                newUUID = UtilGenerator.getUUID();
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

