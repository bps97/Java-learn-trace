package cn.bps.service;

import cn.bps.mapper.LabelMapper;
import cn.bps.pojo.Label;
import cn.bps.pojo.LabelCategory;
import cn.bps.pojo.LabelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LabelServiceImp implements LabelService {

    @Autowired
    private LabelMapper labelMapper;



    /*获得标签分类与标签的字典表*/
    @Override
    public Map<LabelCategory, List<Label>> getLabelMap(Collection<LabelCategory> labelCategories) {

        Map<LabelCategory,List<Label>> map = new HashMap<>();
        for(LabelCategory category: labelCategories){
            map.put(category, getLabelListByCategoryId(category.getId()));
        }

        return map;

    }


    /*通过标签id获得标签列表*/
    @Override
    public List<Label> getLabelListByCategoryId(int labelId) {

        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andLabel_category_idEqualTo(labelId);

        return labelMapper.selectByExample(labelExample);
    }

    /*通过标签名获得标签标签id*/
    @Override
    public Integer findIdByValue(String value) {
        Label label = getLabelByValue(value);
        if(label!=null)
            return label.getId();
        return 0;
    }

    /*通过标签名查找标签*/
    public Label getLabelByValue(String value) {
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andValueEqualTo(value);
        List<Label> labelList = labelMapper.selectByExample(labelExample);
        if (labelList.size()>0){
            return labelList.get(0);
        }
        return null;
    }


    /*通过标签名数组获得标签id*/
    @Override
    public Set<Integer> getLabelIds(String[] values) {
        Set<Integer> set  = new HashSet<>();
        for(int i=0; i< values.length; ++i){
            if(!values[i].equals("全部"))
                set.add(findIdByValue(values[i]));
        }
        return set;
    }


    /*将label标签转换成字符串,以","隔开*/
    @Override
    public String labelIdSetToString(Collection<Integer> labelIdSet) {
        StringBuilder stringBuilder = new StringBuilder();

        int first = 0;
        for(Integer i : labelIdSet){
            if(++first != 1)
                stringBuilder.append(",");
            stringBuilder.append(i);
        }
        return stringBuilder.toString();

    }

    /*查找标签id列表中id对应的标签列表*/
    @Override
    public List<Label> getLabelListByCategoryId(List<Integer> labelIdList) {

        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andIdIn(labelIdList);
        return labelMapper.selectByExample(labelExample);
    }
}
