package com.demo.springboot.angular.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.demo.springboot.angular.model.Product;
import com.demo.springboot.angular.service.ProductService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/saveProduct")
	public void saveProduct(@RequestParam("file") MultipartFile file, @RequestParam("product") String product) throws JsonParseException, JsonMappingException, IOException 
	{
		Product product1= new ObjectMapper().readValue(product,Product.class);
		product1.setLogo(file.getBytes());
		product1.setFileName(file.getOriginalFilename());
		product1.setLast_modified_by(new Date());
		productService.save(product1);
	}

	@GetMapping(value="/products")
	public ResponseEntity<List<Product>> getProducts()
	{
		List<Product> products= productService.getProducts();
		return new  ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Product> save(@RequestBody Product product) throws Exception
	{
		if(product==null)
		{
			throw new NullPointerException("Product Object cannot be null");
		}
		product.setLast_modified_by(new Date());
		Product dbProduct= productService.save(product);
		return new ResponseEntity<Product>(dbProduct, HttpStatus.OK);
	}
	
	@GetMapping(value="/getProduct/{id}")
	public Product getProduct(@PathVariable("id") Long id)
	{
		return productService.findOne(id);
		
		
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<Product> update(@RequestBody Product product)
	{
		if(product==null)
		{
			throw new NullPointerException("Product Object cannot be null");
		}
		product.setLast_modified_by(new Date());
		Product dbProduct= productService.update(product);
		return new ResponseEntity<Product>(dbProduct, HttpStatus.OK);
	}
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable("id") Long id)
	{
		if(id==null)
		{
			throw new NullPointerException("Product Object cannot be null");
		}
		productService.delete(id);

	}

}
