package com.Ibt.acart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ibt.acart.model.Products;
import com.Ibt.acart.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/all")
	public List<Products> productList()
	{
		return productService.productList();
	}
	@GetMapping("/{id}")
	public Products findOne(@PathVariable Long id)
	{
		return productService.findOne(id);
	}
	@PostMapping("/add")
	public String addProduct(@RequestBody Products product)
	{
		return productService.addProduct(product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		return productService.deleteProduct(id);
	}
	@PutMapping("/{id1}")
	public void updateProduct(@PathVariable Long id1,@RequestBody Products product)
	{
		productService.updateProduct(id1,product);
	}
	@GetMapping("category/{id}")
	public List<Products> productListbyCategory(@PathVariable Long id)
	{
		return productService.productListbyCategory(id);
	}
}
