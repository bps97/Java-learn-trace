package cn.bps.service;

import cn.bps.pojo.SubCategory;

import java.util.List;
import java.util.Map;

public interface CategoryDemoSerivce {
    List<SubCategory> getCategoryDemos(int id);
    Map<Integer,List<SubCategory>> getCategoryProduct();
}
