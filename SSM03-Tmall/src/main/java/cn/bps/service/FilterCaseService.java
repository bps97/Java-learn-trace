package cn.bps.service;

import cn.bps.pojo.FilterCase;

import java.util.List;

public interface FilterCaseService {

    List<FilterCase> getFilterList();

    List<Integer> getFilterIdList();

}
