package com.checonbinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/details")
public class DetailsController {
	@GetMapping
	public String Default() {
		return "details";
	}
	
//	@PostMapping
//	public String DisplayUser(@ModelAttribute NhanVien nv, ModelMap modelMap) // co bao nhieu bien co ban Nhan vien phai day du tham so
//	{
//		modelMap.addAttribute("nv", nv);
//		return "details";
//	}
}
