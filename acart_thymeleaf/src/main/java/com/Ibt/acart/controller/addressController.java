package com.Ibt.acart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ibt.acart.model.Address;
import com.Ibt.acart.service.AddressService;

@RestController
@RequestMapping("/address")
public class addressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/all")
	public List<Address> addressList()
	{
		return addressService.addressList();
	}
	@GetMapping("/{id}")
	public Address findOne(@PathVariable Long id)
	{
		return addressService.findOne(id);
	}
	@PostMapping("/add")
	public Address addAddress(@RequestBody Address address)
	{
		return addressService.addAddress(address);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id)
	{
		return addressService.deleteAddress(id);
	}
	@PutMapping("/{id1}/{id2}")
	public void updateAddress(@PathVariable Long id1,@PathVariable Long id2,@RequestBody Address address)
	{
		 addressService.updateAddress(id1,id2,address);
	}
}
