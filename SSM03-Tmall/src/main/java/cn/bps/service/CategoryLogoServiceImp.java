package cn.bps.service;

import cn.bps.mapper.CategoryLogoMapper;
import cn.bps.pojo.CategoryLogoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryLogoServiceImp implements CategoryLogoService {

    @Autowired
    CategoryLogoMapper categoryLogoMapper;

    @Override
    public Map<Integer, String> getCategoryLogoMap() {
        return categoryLogoMapper.selectByExample(new CategoryLogoExample())
                        .stream()
                        .collect(Collectors.toMap((ele)->ele.getId(),(ele)->ele.getLink()));

    }
}
