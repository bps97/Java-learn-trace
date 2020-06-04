package cn.bps.heam.biz;

import cn.bps.common.lang.api.Filter;
import cn.bps.common.lang.api.Page;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.result.HomeProductResult;
import cn.bps.heam.domain.result.ProductResult;

import java.util.List;

public interface ProductBiz {

    Page<ProductResult> pageProducts(PageRequest pageRequest);

    Page<ProductResult> pageProducts(PageRequest pageRequest, Filter filter);

    HomeProductResult getHomeProduct(String categoryName);

    List<HomeProductResult> getHomeProduct(List<String> categoryNames);

    ProductResult getProduct(String id);
}
