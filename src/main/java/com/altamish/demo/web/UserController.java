package com.altamish.demo.web;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altamish.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{userid}")
	public String displayUser(@PathVariable int userid) {
		
		return "User found: "+userid;
	}
	
	@RequestMapping("/{id}/invoice")
	public String displayUserInvoice(@PathVariable("id") int userid, @RequestParam(value = "d", required = false) Date dateOrnull ) {
		
		return "Invoice found for user: "+	userid + " for date: "+ dateOrnull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson(){
		return Arrays.asList("Shoes","Laptop","Button");
	}
	
	@RequestMapping("/{userId}/products-as-json")
	public List<Product> ProductsAsJson(){
		return Arrays.asList(new Product("Nike", 1, 100.99),
				new Product("Books", 2, 146.99),
				new Product("Bag", 1, 89.69));
	}

}
