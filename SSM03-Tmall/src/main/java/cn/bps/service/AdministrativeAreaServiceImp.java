package cn.bps.service;

import cn.bps.mapper.AdministrativeAreaMapper;
import cn.bps.pojo.AdministrativeArea;
import cn.bps.pojo.AdministrativeAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdministrativeAreaServiceImp implements AdministrativeAreaService {

    @Autowired
    private AdministrativeAreaMapper administrativeAreaMapper;


    @Override
    public List<AdministrativeArea> getProvinces() {
        AdministrativeAreaExample administrativeAreaExample = new AdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andLevel_typeEqualTo(1);
        return administrativeAreaMapper.selectByExample(administrativeAreaExample);
    }

	@Override
    public List<AdministrativeArea> getChildrenCities(String parentCode) {
        AdministrativeAreaExample administrativeAreaExample = new AdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andParent_idEqualTo(parentCode);
        return administrativeAreaMapper.selectByExample(administrativeAreaExample);
    }

	@Override
    public Map<String, String> toTuple(List<AdministrativeArea> administrativeAreas) {

        Map<String,String> tuple = new HashMap<>();
        for(AdministrativeArea administrativeArea : administrativeAreas){
            tuple.put(administrativeArea.getCode(), administrativeArea.getName());
        }

        return tuple;
    }

	@Override
    public String getCityName(String cityCode) {
        AdministrativeAreaExample administrativeAreaExample = new AdministrativeAreaExample();
        administrativeAreaExample.createCriteria().andCodeEqualTo(cityCode);

        return administrativeAreaMapper.selectByExample(administrativeAreaExample).get(0).getName();
    }


}
