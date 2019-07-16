package com.Ibt.acart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ibt.acart.model.Products;
import com.Ibt.acart.repository.ProductRepository;
import com.Ibt.acart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Products> productList() {
		
		return (List<Products>) productRepository.findAll();
	}

	@Override
	public Products findOne(Long id) {
	
		return productRepository.findOne(id);
	}

	@Override
	public String addProduct(Products product) {
		productRepository.save(product);
		return "Product added successfully";
	}

	@Override
	public String deleteProduct(Long id) {
		productRepository.delete(id);
		return "Product deleted Successfully";
	}

	@Override
	public void updateProduct(Long id1,Products product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public List<Products> productListbyCategory(Long id) {
		
		return (List<Products>) productRepository.productListbyCategory(id);
	}
	
	

}
