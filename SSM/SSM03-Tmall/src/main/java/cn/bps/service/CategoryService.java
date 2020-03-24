package cn.bps.service;

import cn.bps.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    List<List<Category>> getAllCategory(int size);

    List<Category> getCategories();

    Map<Integer,String> getCategoryMap();
}
