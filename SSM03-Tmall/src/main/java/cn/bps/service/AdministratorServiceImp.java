package cn.bps.service;

import cn.bps.mapper.AdministratorMapper;
import cn.bps.pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImp implements  AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public boolean check(Administrator administrator) {

        Administrator admin = administratorMapper.selectByPrimaryKey(administrator.getUsername());

        if(admin==null){
            return false;
        }

        if(!administrator.getPassword().equals(admin.getPassword())){
            return false;
        }
        return  true;
    }
}
