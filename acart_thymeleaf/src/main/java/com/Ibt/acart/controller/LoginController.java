package com.Ibt.acart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ibt.acart.model.Register_Model;
import com.Ibt.acart.model.User;
import com.Ibt.acart.service.AcartServiceException;
import com.Ibt.acart.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	// to get login form page
	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}

	// Checking for login credentials
	@PostMapping("/login")
	public String login(@ModelAttribute(name = "User") User user, Model model) {

		String result = userService.login(user, model);
		if (("login").equals(result)) {
			model.addAttribute("invalidCredentials", true);
		}
		return result;
	}

	@GetMapping("/Register")
	public String RegisterForm(@ModelAttribute(name = "Register_Model") Register_Model register, Model model) {
		return "Register";
	}

	// Checking for login credentials
	@PostMapping("/Register")
	public String Register(@ModelAttribute(name = "Register_Model") Register_Model register, Model model) {
		User user = new User();
		// model.addAttribute("register",new Register_Model());
		String password = register.getPassword();
		String confirm_pass = register.getConfirm_password();
		user.setUser_name(register.getName());
		user.setMail_id(register.getMail_id());
		if (password.equals(confirm_pass)) {
			user.setPassword(register.getPassword());
			userService.addUser(user);
		} else {
			return "Register";
		}

		return "Register";
	}

	@RequestMapping("/Users")
	public String countsList(Model model) {
		model.addAttribute("users", userService.userList());
		return "Users";
	}

	@RequestMapping("/User/{id}")
	public String user(Model model, @PathVariable Long id) throws AcartServiceException {
		model.addAttribute("user", userService.findOne(id));
		return "User";
	}

}
