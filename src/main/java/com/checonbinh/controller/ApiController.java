package com.checonbinh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.checonbinh.service.EmployeeService;

@Controller
@RequestMapping("api/")
public class ApiController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String name, @RequestParam String password) {
		boolean checkLogin = employeeService.checkLogin(name, password);
		
		return ""+checkLogin;
	}
}
