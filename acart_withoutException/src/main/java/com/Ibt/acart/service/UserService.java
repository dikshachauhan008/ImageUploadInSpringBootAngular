package com.Ibt.acart.service;

import java.util.List;
import java.util.Optional;

import com.Ibt.acart.model.User;

public interface UserService {
	List<User> userList();
	User findOne(Long id);
	void addUser(User user);
	String deleteUser(Long id);
	String updateUser(Long id, User user);
}
