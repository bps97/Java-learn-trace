package cn.bps.service;

import cn.bps.pojo.Address;

import java.util.List;

public interface AddressService {


    int addAddress(Address address);

    List<Address> getAddressesByUserId(int userId);
    List<Address> getAddressesByUserIdExceptDefault(int userId);
    Address getDefaultAddressByUserId(int userId);

    Integer delAddressByAddressID(int addressId);

    Integer updateSetDefaultAddressById(int addressId);
}
