package cn.bps.service;

import cn.bps.pojo.Label;
import cn.bps.pojo.LabelCategory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LabelService {

    Map<LabelCategory, List<Label>> getLabelMap(Collection<LabelCategory> labelCategories);


    Integer findIdByValue(String value);

    Set<Integer> getLabelIdSet(String[] values);

    String labelIdSetToString(Collection<Integer> filterSet);

    List<Label> getLabelList(List<Integer> filterIdList);

    List<Label> getLabelList(int id);

}
