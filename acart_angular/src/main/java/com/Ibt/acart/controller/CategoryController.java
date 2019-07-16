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

import com.Ibt.acart.model.Categories;

import com.Ibt.acart.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired 
	private CategoryService categoryService;
	@GetMapping("/all")
	public List<Categories> categoryList()
	{
		return categoryService.categoryList();
	}
	
	@GetMapping("/{id}")
	public Categories findOne(@PathVariable Long id)
	{
			return categoryService.findOne(id);
	}
	@PostMapping("/add")
	public void addCategory(@RequestBody Categories category)
	{
		categoryService.addCategory(category);
	}
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id)
	{
		return categoryService.deleteCategory(id);
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable Long id, @RequestBody Categories category)
	{
		return categoryService.updateCategory(id, category);
	}

	
}
