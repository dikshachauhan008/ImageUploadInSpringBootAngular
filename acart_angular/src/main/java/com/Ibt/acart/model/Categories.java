package com.Ibt.acart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long category_id;
	String category_name;
	@OneToMany(targetEntity=Products.class, mappedBy="category_id",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Products> products;
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public Categories() {
	}
	public Categories(Long category_id, String category_name, List<Products> products) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.products = products;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


}
