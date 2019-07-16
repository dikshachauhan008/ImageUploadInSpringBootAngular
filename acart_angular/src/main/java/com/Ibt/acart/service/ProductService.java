package com.Ibt.acart.service;

import java.util.List;

import com.Ibt.acart.model.Products;

public interface ProductService {

	List<Products> productList();

	Products findOne(Long id);

	String addProduct(Products product);

	String deleteProduct(Long id);

	void updateProduct(Long id1, Products product);

	List<Products> productListbyCategory(Long id);

}
