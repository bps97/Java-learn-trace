package cn.bps.service;

import cn.bps.pojo.Address;

import java.util.List;

public interface AddressService {

    int addAddress(Address address);

    int delAddressByAddressID(int addressId);

    int setDefaultAddressById(int addressId);

    List<Address> getAddressList(int userId);

    List<Address> getAddressListExceptDefault(int userId);

    Address getDefaultAddressByUserId(int userId);

    Address getAddressByAddressID(Integer addressId);
}
