package com.demo.springboot.angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.angular.model.Product;
import com.demo.springboot.angular.repository.ProductRepository;

@Service

public class ProductService {
	
	@Autowired 
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		
		return  productRepository.findAll();
	}

	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

	public Product update(Product product) {

		return productRepository.save(product);
	}

	public void delete(Long id) {
		
		 productRepository.delete(id);
	}

}
