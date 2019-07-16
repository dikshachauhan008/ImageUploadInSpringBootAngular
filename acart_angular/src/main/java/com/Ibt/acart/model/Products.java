package com.Ibt.acart.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long product_id;
	Long category_id;
	String product_name;
	String description;
	String short_desc;
	double price;
	float delivery_charges;
	float discount;
	String image_path;
	String last_modified_by;
	Long seller_id;
	public Long getProduct_id() {
		return product_id;
	}
	public Products() {
	
	}
	public Products(Long product_id, String product_name, Long category_id, String description, String short_desc,
			double price, float delivery_charges, float discount, String image_path, String last_modified_by) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category_id = category_id;
		this.description = description;
		this.short_desc = short_desc;
		this.price = price;
		this.delivery_charges = delivery_charges;
		this.discount = discount;
		this.image_path = image_path;
		this.last_modified_by = last_modified_by;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getDelivery_charges() {
		return delivery_charges;
	}
	public void setDelivery_charges(float delivery_charges) {
		this.delivery_charges = delivery_charges;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getLast_modified_by() {
		return last_modified_by;
	}
	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	
	
}
