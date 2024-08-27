package com.checonbinh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.boot.model.internal.XMLContext.Default;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checonbinh.entity.Cart;

@Controller
@RequestMapping("cart/")
public class CartController {
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("countCart", carts.size());
			modelMap.addAttribute("carts", carts);
		}
		return "cart";
	}
}
