package com.checonbinh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.checonbinh.entity.Cart;
import com.checonbinh.entity.Product;
import com.checonbinh.service.ProductService;
@Controller
@RequestMapping("/details")
@SessionAttributes("cart")
public class DetailsController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{idProduct}")
	public String Default(@PathVariable int idProduct, ModelMap modelMap, HttpSession httpSession) {
		Product product = productService.ProductDetails(idProduct);
		modelMap.addAttribute("product", product);
		
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("countCart", carts.size());
		}
		
		return "detail";
	}
	
//	@PostMapping
//	public String DisplayUser(@ModelAttribute NhanVien nv, ModelMap modelMap) // co bao nhieu bien co ban Nhan vien phai day du tham so
//	{
//		modelMap.addAttribute("nv", nv);
//		return "details";
//	}
}
