package com.checonbinh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checonbinh.entity.Product;
import com.checonbinh.service.ProductService;
@Controller
@RequestMapping("/details")
public class DetailsController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{idProduct}")
	public String Default(@PathVariable int idProduct, ModelMap modelMap) {
		Product product = productService.ProductDetails(idProduct);
		modelMap.addAttribute("product", product);
		return "detail";
	}
	
//	@PostMapping
//	public String DisplayUser(@ModelAttribute NhanVien nv, ModelMap modelMap) // co bao nhieu bien co ban Nhan vien phai day du tham so
//	{
//		modelMap.addAttribute("nv", nv);
//		return "details";
//	}
}
