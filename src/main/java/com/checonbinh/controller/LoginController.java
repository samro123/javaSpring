package com.checonbinh.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.checonbinh.entity.Employee;
import com.checonbinh.service.EmployeeService;

@Controller
@RequestMapping("login/")
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public String Default() {
		return "login";
	}
	
	@PostMapping
	public String Register(@RequestParam String name, @RequestParam String password, @RequestParam String confirmPassword, ModelMap modelMap) {
		boolean checkEmail = validate(name);
		if(checkEmail) {
			if(password.equals(confirmPassword)) { 
				Employee employee = new Employee();
				employee.setEmail(name);
				employee.setPassword(password);
				boolean checkAddEmployee =  employeeService.addEmployee(employee);
				if(checkAddEmployee) {
					modelMap.addAttribute("checkLogin", "Success");
				}else {
					modelMap.addAttribute("checkLogin", "Failure");
				}
				
			}else {
				modelMap.addAttribute("checkLogin", "Please password");
			}
		}else {
			modelMap.addAttribute("checkLogin", "Please email");
		}
		return "login";
	}
	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.matches();
		}
	
}
