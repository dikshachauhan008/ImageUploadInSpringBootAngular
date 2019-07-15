package com.Ibt.acart.controller;
import java.util.List;

import com.Ibt.acart.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ibt.acart.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> userList()
	{
		return userService.userList();
	}
	
	@GetMapping("/{id}")
	public User findOne(@PathVariable Long id)
	{
		return userService.findOne(id);
	}
	@PostMapping("/add")
	public void addUser(@RequestBody User user)
	{
       userService.addUser(user);
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		return userService.deleteUser(id);
	}
	
	@PutMapping("/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody User user)
	{
		return userService.updateUser(id, user);
	}
	
}
