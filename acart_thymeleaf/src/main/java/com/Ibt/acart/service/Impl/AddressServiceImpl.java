package com.Ibt.acart.service.Impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ibt.acart.model.Address;

import com.Ibt.acart.repository.AddressRepository;
import com.Ibt.acart.repository.UserRepository;
import com.Ibt.acart.service.AddressService;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Address> addressList() {
		
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public Address findOne(Long id) {
		
		return addressRepository.findOne(id);
	}

	@Override
	public Address addAddress(Address address) {
		address.setLastModifiedBy(((userRepository.findOne(address.getUser_id())).getUser_name()));
		addressRepository.save(address);
		return address;
		
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.delete(id);
		return "Address deleted successfully";
	}

	@Override
	@Transactional
	public void updateAddress(Long id1, Long id2, Address address) {
		//List<Address> addressList=new ArrayList<Address> ();
		addressRepository.save(address);
		/*addressList.addAll(((userRepository.findOne(id1)).getAddresses()));
		for(int i=0; i<addressList.size();i++)
		{
			if((addressList.get(i)).getAddress_id()==id2)
			{
				addressList.set(i,address);
			}
		}
		(userRepository.findOne(id1)).setAddresses(addressList);
		addressRepository.save(address);*/
	}


}
