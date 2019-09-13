package cn.bps.service;

import cn.bps.mapper.FilterCaseMapper;
import cn.bps.pojo.FilterCase;
import cn.bps.pojo.FilterCaseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterCaseServiceImp implements FilterCaseService{

    @Autowired
    private FilterCaseMapper filterCaseMapper;

    @Override
    public List<FilterCase> getFilterList() {
        FilterCaseExample filterExample = new FilterCaseExample();
        return filterCaseMapper.selectByExample(filterExample);
    }

    @Override
    public List<Integer> getFilterIdList() {
        List<FilterCase> filterlist = getFilterList();
        List<Integer> filterIdlist = new ArrayList<>();
        for(FilterCase fc: filterlist){
            filterIdlist.add(fc.getId());
        }
        return filterIdlist;
    }
}
