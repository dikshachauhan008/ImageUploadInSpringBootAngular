package com.Ibt.acart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ibt.acart.model.Categories;
import com.Ibt.acart.repository.CategoryRepository;
import com.Ibt.acart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Categories> categoryList() {
		
		return (List<Categories>) categoryRepository.findAll();
	}

	@Override
	public Categories findOne(Long id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public void addCategory(Categories category) {
		categoryRepository.save(category);
		
	}

	@Override
	public String deleteCategory(Long id) {
		categoryRepository.delete(id);
		return "Category deleted successfully";
	}

	@Override
	public String updateCategory(Long id, Categories category) {
		categoryRepository.save(category);
		return "Category updated successfully";
	}

}
