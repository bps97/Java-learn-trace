package cn.bps.service;

import cn.bps.mapper.PropertyMapper;
import cn.bps.pojo.Property;
import cn.bps.pojo.PropertyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImp implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;
    @Override
    public List<Property> getPropertyListByCategoryId(int categoryId) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createCriteria().andCategory_idEqualTo(categoryId);
        return propertyMapper.selectByExample(propertyExample);
    }
}
