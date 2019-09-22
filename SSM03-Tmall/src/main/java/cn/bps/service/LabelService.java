package cn.bps.service;

import cn.bps.pojo.Label;
import cn.bps.pojo.LabelCategory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LabelService {

    public Map<LabelCategory, List<Label>> getLabelMap(Collection<LabelCategory> labelCategories);

    List<Label> getLabelListByCategoryId(int id);

    Integer findIdByValue(String value);

    Set<Integer> getLabelIds(String[] values);

    String labelIdSetToString(Collection<Integer> filterSet);

    List<Label> getLabelListByCategoryId(List<Integer> filterIdList);
}
