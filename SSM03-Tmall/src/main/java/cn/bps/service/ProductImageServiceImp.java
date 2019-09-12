package cn.bps.service;

import cn.bps.mapper.ProductImageMapper;
import cn.bps.pojo.Product;
import cn.bps.pojo.ProductImage;
import cn.bps.pojo.ProductImageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductImageServiceImp implements ProductImageService {

    @Autowired
    private ProductImageMapper productImageMapper;



    @Override
    public Map<Integer, String> getImageUrls(Collection<Product> products) {
        Map<Integer, String> map = new HashMap();

        for(Product product:products){
            ProductImageExample productImageExample = new ProductImageExample();
            int id = product.getId();
            productImageExample.createCriteria().andProduct_idEqualTo(id);
            List<ProductImage> productImage = productImageMapper.selectByExample(productImageExample);
            if(productImage.size()>0){
                map.put(id,productImage.get(0).getImage_link());
            }else {
                map.put(id,"http://temp.im/200x200");
            }

        }

        return map;
    }

    @Override
    public String getImageUrl(Integer productId) {
        ProductImageExample productImageExample = new ProductImageExample();
        productImageExample.createCriteria().andProduct_idEqualTo(productId);
        List<ProductImage> productImages = productImageMapper.selectByExample(productImageExample);

        return productImages.get(0).getImage_link();
    }

    @Override
    public int addProductImage(Integer productId, String imgUrl) {

        ProductImage productImage = new ProductImage();
        productImage.setImage_link(imgUrl);
        productImage.setProduct_id(productId);


        return productImageMapper.insert(productImage);
}


}
