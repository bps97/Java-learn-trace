package cn.bps.service;

import cn.bps.pojo.Category;
import cn.bps.pojo.CategoryDemo;

import java.util.List;
import java.util.Map;

public interface CategoryDemoSerivce {
    List<CategoryDemo> getCategoryDemos(int id);
    Map<Integer,List<CategoryDemo>> getCategoryProduct();
}
