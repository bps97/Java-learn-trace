package cn.bps.service;

import cn.bps.pojo.ConcreteFilter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConcreteFilterService {

    Map<Integer, List<ConcreteFilter>> getFilterMap(Collection<Integer> filterIdList);

    List<ConcreteFilter> getFilterListById(int id);

    Integer getFilterIdByValue(String value);

    Set<Integer> getFilterIdByValues(String[] values);

    String getFilterIds(Collection<Integer> filterSet);

    List<ConcreteFilter> getConcreteFilterByIds(List<Integer> filterIdList);
}
