package com.checonbinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login/")
public class LoginController {

	@GetMapping
	public String Default() {
		return "login";
	}
	
	@PostMapping
	public String processLogin(@RequestParam String name, @RequestParam String password) {
		if(name.equals("sam") && password.equals("1234567")) {
			return "redirect:/home";
		}
		else {
			return "login";
		}
	}
}
