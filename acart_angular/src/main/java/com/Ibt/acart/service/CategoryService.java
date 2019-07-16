package com.Ibt.acart.service;

import java.util.List;

import com.Ibt.acart.model.Categories;

public interface CategoryService {

	List<Categories> categoryList();

	Categories findOne(Long id);

	void addCategory(Categories category);

	String deleteCategory(Long id);

	String updateCategory(Long id, Categories category);

}
