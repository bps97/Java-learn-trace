package cn.bps.service;

import cn.bps.pojo.Property;

import java.util.List;

public interface PropertyService {


    List<Property> getPropertyListByCategoryId(int categoryId);

}
