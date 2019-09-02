package cn.bps.service;

import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.FilterCase;

import java.util.List;
import java.util.Map;

public interface ConcreteFilterService {

    Map<Integer, List<ConcreteFilter>> getFilterMap();

    List<ConcreteFilter> getFilterCaseList(int id);



}
