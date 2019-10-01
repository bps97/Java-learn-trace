package cn.bps.service;


import cn.bps.mapper.AddressMapper;
import cn.bps.pojo.Address;
import cn.bps.pojo.AddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {


    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int addAddress(Address address) {

        List<Address> addresses = getAddressList(address.getUser_id());
        if(addresses.size()==0){
            address.setDefault_address(1);
        }else{
            address.setDefault_address(0);
        }

        return addressMapper.insert(address);
    }

	@Override
    public List<Address> getAddressList(int userId) {

        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUser_idEqualTo(userId);
        return addressMapper.selectByExample(addressExample);

    }

	@Override
    public List<Address> getAddressListExceptDefault(int userId) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUser_idEqualTo(userId).andDefault_addressEqualTo(0);
        return addressMapper.selectByExample(addressExample);
    }

	@Override
    public Address getDefaultAddressByUserId(int userId) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUser_idEqualTo(userId).andDefault_addressEqualTo(1);
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        if(addresses.size()>0){
            return addresses.get(0);
        }
        return null;
    }

	@Override
    public int delAddressByAddressID(int addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);

    }

	@Override
    public int setDefaultAddressById(int addressId) {

        AddressExample addressExample  = new AddressExample();
        addressExample.createCriteria().andIdEqualTo(addressId);
        Address address = addressMapper.selectByExample(addressExample).get(0);

        Address defaultAddress = getDefaultAddressByUserId(address.getUser_id());
        defaultAddress.setDefault_address(0);
        addressMapper.updateByPrimaryKey(defaultAddress);

        address.setDefault_address(1);
        return addressMapper.updateByPrimaryKey(address);

    }

	@Override
    public Address getAddressByAddressID(Integer addressId) {


        return addressMapper.selectByPrimaryKey(addressId);
    }
}
