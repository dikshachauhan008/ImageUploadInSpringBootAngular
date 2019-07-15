package com.Ibt.acart.service;

import java.util.List;

import com.Ibt.acart.model.Address;

public interface AddressService {
	
	List<Address> addressList();
	Address findOne(Long id);
	Address addAddress(Address address);
	String deleteAddress(Long id);
	void updateAddress(Long id1,Long id2, Address address);
}
