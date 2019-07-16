package com.Ibt.acart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ibt.acart.model.Products;



@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {

	@Query("SELECT products FROM Products products where products.category_id = :id") 
	List<Products> productListbyCategory(@Param("id") Long id);

}
