package com.checonbinh.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.checonbinh.entity.Cart;
import com.checonbinh.service.EmployeeService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","cart"})
public class ApiController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
		boolean checkLogin = employeeService.checkLogin(name, password);
		modelMap.addAttribute("user", name);
		return ""+checkLogin;
	}
	
	
	@GetMapping("loadCart")
	@ResponseBody
	public String loadCart(@RequestParam int idProduct, @RequestParam int idColor, @RequestParam int idSize, @RequestParam int quantity, HttpSession httpSession ) {
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int indexCart = checkProductAvalibleCart(carts, httpSession, idProduct,idColor, idSize);
			carts.get(indexCart).setQuantity(quantity);

		}
		return "";
	}
	
	@GetMapping("removeCart")
	@ResponseBody
	public String loadCart(@RequestParam int idProduct, @RequestParam int idColor, @RequestParam int idSize, HttpSession httpSession ) {
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int indexCart = checkProductAvalibleCart(carts, httpSession, idProduct,idColor, idSize);
			carts.remove(indexCart);

		}
		return "";
	}
	
	@GetMapping("addCart")
	@ResponseBody
	public void addCart(@RequestParam int idProduct,@RequestParam int idColor,@RequestParam int idSize,@RequestParam String nameProduct,@RequestParam String price,@RequestParam String nameSize,@RequestParam String nameColor,@RequestParam String img,@RequestParam int quantity, @RequestParam int idDetail, HttpSession httpSession ) {
		
		if(null == httpSession.getAttribute("cart")) {
			List<Cart> carts = new ArrayList<Cart>();
			carts.add(cart(idProduct, idColor, idSize, nameProduct, price, nameSize, nameColor, img, quantity, idDetail));
			httpSession.setAttribute("cart", carts);
		}else {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int indexCart = checkProductAvalibleCart(carts, httpSession, idProduct,idColor, idSize);
			if(indexCart == -1) {
			 carts.add(cart(idProduct, idColor, idSize, nameProduct, price, nameSize, nameColor,img, quantity, idDetail));

			}else {
				int newCount = carts.get(indexCart).getQuantity() + 1;
				carts.get(indexCart).setQuantity(newCount);
			}
		}
		
		List<Cart> listCart = (List<Cart>) httpSession.getAttribute("cart");
		System.out.println("----");
		for(Cart cart: listCart) {
		System.out.println(cart.getImg() + "-" + cart.getNameColor() + "-" + cart.getQuantity());
		}
	}
	
	@GetMapping("countCart")
	@ResponseBody
	public String giveCountCart(HttpSession httpSession) {
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			return carts.size() + ""; 
		}
		return "";
	}
	
	
	
	private Cart cart(int idProduct,int idColor,int idSize,String nameProduct, String price, String nameSize, String nameColor,String img, int quantity, int idDetail) {
		Cart cart = new Cart();
		cart.setIdProduct(idProduct);
		cart.setIdColor(idColor);
		cart.setIdSize(idSize);
		cart.setNameColor(nameColor);
		cart.setNameProduct(nameProduct);
		cart.setNameSize(nameSize);
		cart.setPrice(price);
		cart.setImg(img);
		cart.setQuantity(1);
		cart.setIdDetail(idDetail);
		return cart;
		
	}
	
	
	private int checkProductAvalibleCart(List<Cart> carts, HttpSession httpSession, int idProduct, int idColor, int idSize) {
		for(int index = 0 ; index< carts.size(); index ++) {
			if(carts.get(index).getIdProduct() == idProduct && carts.get(index).getIdColor() == idColor && carts.get(index).getIdSize() == idSize) {
				return index;
			}
		}
		return -1;
	}
	
	
	
}
