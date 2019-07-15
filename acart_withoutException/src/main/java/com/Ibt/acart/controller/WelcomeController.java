package com.Ibt.acart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String Welcome()
	{
		return "Welcome to Acart!!";
	}
}
