package cn.bps.service;

import cn.bps.mapper.LabelCategoryMapper;
import cn.bps.pojo.LabelCategory;
import cn.bps.pojo.LabelCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelCategoryServiceImp implements LabelCategoryService {

    @Autowired
    private LabelCategoryMapper labelCategoryMapper;

    @Override
    public List<LabelCategory> getAllLabelCategory() {
        LabelCategoryExample filterExample = new LabelCategoryExample();
        return labelCategoryMapper.selectByExample(filterExample);
    }

	@Override
    public List<Integer> getAllLabelCategoryIds() {
        List<LabelCategory> allLabelCategory = getAllLabelCategory();
        List<Integer> labelCategoryList = new ArrayList<>();
        for(LabelCategory fc: allLabelCategory){
            labelCategoryList.add(fc.getId());
        }
        return labelCategoryList;
    }
}
