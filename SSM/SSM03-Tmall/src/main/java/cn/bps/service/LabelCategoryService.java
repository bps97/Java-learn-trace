package cn.bps.service;

import cn.bps.pojo.LabelCategory;

import java.util.List;

public interface LabelCategoryService {

    List<LabelCategory> getAllLabelCategory();

    List<Integer> getAllLabelCategoryIds();

}
