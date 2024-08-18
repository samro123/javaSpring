package com.checonbinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("login/")
@SessionAttributes("name")
public class LoginController {

	@GetMapping
	public String Default() {
		return "login";
	}
	
}
