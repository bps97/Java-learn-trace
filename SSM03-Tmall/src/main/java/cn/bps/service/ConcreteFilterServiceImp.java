package cn.bps.service;

import cn.bps.mapper.ConcreteFilterMapper;
import cn.bps.pojo.ConcreteFilter;
import cn.bps.pojo.ConcreteFilterExample;
import cn.bps.pojo.FilterCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ConcreteFilterServiceImp implements ConcreteFilterService {

    @Autowired
    ConcreteFilterMapper concreteFilterMapper;


    @Override
    public Map<Integer, List<ConcreteFilter>> getFilterMap(List<Integer> filterIdList) {


        Map<Integer, List<ConcreteFilter>> map = new HashMap<>();
        if(filterIdList != null)
        for(Integer id:filterIdList){
            map.put(id, getFilterListById(id));
        }
        return map;
    }

    @Override
    public List<ConcreteFilter> getFilterListById(int id) {

        ConcreteFilterExample concreteFilterExample = new ConcreteFilterExample();
        concreteFilterExample.createCriteria().andFilter_case_idEqualTo(id);

        return concreteFilterMapper.selectByExample(concreteFilterExample);
    }

    @Override
    public Integer getFilterIdByValue(String value) {

        ConcreteFilterExample concreteFilterExample = new ConcreteFilterExample();
        concreteFilterExample.createCriteria().andValueEqualTo(value);
        List<ConcreteFilter> concreteFilterList = concreteFilterMapper.selectByExample(concreteFilterExample);
        if (concreteFilterList.size()>0){
            return concreteFilterList.get(0).getId();
        }

        return 0;
    }

    @Override
    public Set<Integer> getFilterIdByValues(String[] values) {
        Set<Integer> set  = new HashSet<>();
        for(int i=0; i< values.length; ++i){
            set.add(getFilterIdByValue(values[i]));
        }
        return set;
    }
}
