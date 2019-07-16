package com.Ibt.acart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ibt.acart.model.Categories;


@Repository
public interface CategoryRepository extends CrudRepository<Categories,Long> {

}
