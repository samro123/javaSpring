package com.checonbinh.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.boot.model.internal.XMLContext.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checonbinh.entity.Bill;
import com.checonbinh.entity.Cart;
import com.checonbinh.entity.DetailBill;
import com.checonbinh.entity.DetailBillId;
import com.checonbinh.service.BillService;
import com.checonbinh.service.DetailBillService;

@Controller
@RequestMapping("cart/")
public class CartController {
	@Autowired
	BillService billService;
	
	@Autowired
	DetailBillService detailBillService;
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("countCart", carts.size());
			modelMap.addAttribute("carts", carts);
		}
		return "cart";
	}
	
	@PostMapping
	public String addBill(
			@RequestParam String nameCustomer,
			@RequestParam String phone,
			@RequestParam String address,
			@RequestParam String notes,
			HttpSession httpSession
			) {
		System.out.println(nameCustomer);
		
		if(null != httpSession.getAttribute("cart")) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			Bill bill = new Bill();
			bill.setNameCustomer(nameCustomer);
			bill.setPhone(phone);
			bill.setAddress(address);
			bill.setNotes(notes);
			int idBill = billService.addBill(bill);
			if(idBill > 0) {
				
				for(Cart cart:carts) {
					DetailBillId detailBillId = new DetailBillId();
					detailBillId.setIdDetailProduct(cart.getIdDetail());
					detailBillId.setIdBill(bill.getIdBill());
					
					DetailBill detailBill = new DetailBill();
					detailBill.setDetailBillId(detailBillId);
					detailBill.setPrice(cart.getPrice());
					detailBill.setQuantity(cart.getQuantity());
					
					detailBillService.addDetailBill(detailBill);
				} 
				
				System.out.println("Succu");
			}else {
				System.out.println("Fauil");
			}
			
			
			
			
			
			
			
			
		}
		
		return "cart";
	}
}
