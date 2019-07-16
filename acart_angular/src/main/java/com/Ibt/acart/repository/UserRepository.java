package com.Ibt.acart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ibt.acart.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{


/*	@Query("select password from user where user_name=?1")
	String findByUser_Name(String user_name);*/

}
