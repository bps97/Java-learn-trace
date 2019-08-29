package cn.bps.service;

import cn.bps.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<List<Category>> getCategories(int size);
    List<Category> getCategories();
}
