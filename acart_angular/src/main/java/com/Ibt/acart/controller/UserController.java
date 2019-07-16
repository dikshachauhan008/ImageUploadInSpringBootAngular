package com.Ibt.acart.controller;
import java.util.List;

import com.Ibt.acart.exceptionhandling.ResourceNotFountException;
import com.Ibt.acart.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ibt.acart.service.AcartServiceException;
import com.Ibt.acart.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
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
	public User findOne(@PathVariable Long id) throws ResourceNotFountException, AcartServiceException
	{
		try {
			User user = userService.findOne(id);
			if (user == null) {
				throw new ResourceNotFountException("User not found");
			}
			return user;
		} catch (AcartServiceException e) {
			throw new AcartServiceException("Internal Server Exception while getting exception");
		}
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
    @PutMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }
	
}
