package cn.bps.service;

import cn.bps.mapper.ConcreteFilterMapper;
import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.ConcreteFilterExample;
import cn.bps.pojo.FilterCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ConcreteFilterServiceImp implements ConcreteFilterService {

    @Autowired
    ConcreteFilterMapper concreteFilterMapper;

    @Autowired
    FilterCaseService filterCaseService;

    @Override
    public Map<Integer, List<ConcreteFilter>> getFilterMap() {

        List<FilterCase> filterCaseList = filterCaseService.getFilterList();
        Map<Integer, List<ConcreteFilter>> map = new HashMap<>();
        for(FilterCase fc:filterCaseList){
            map.put(fc.getId(),getFilterCaseList(fc.getId()));
        }
        return map;
    }

    @Override
    public List<ConcreteFilter> getFilterCaseList(int id) {

        ConcreteFilterExample concreteFilterExample = new ConcreteFilterExample();
        concreteFilterExample.createCriteria().andFilter_case_idEqualTo(id);
        return concreteFilterMapper.selectByExample(concreteFilterExample);
    }
}
