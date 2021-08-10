package com.altamish.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {
	
	@RequestMapping("/basic")
	public String sayHello() {
		return "<h1>Heylo</h1>";
	}
	
	@RequestMapping(value = "/proper", method = RequestMethod.GET)
	public String sayProperHello() {
		return "<h1>Hello there, How are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"GET\">\r\n"
				+ "  <label for=\"fname\">First name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\r\n"
				+ "  <label for=\"lname\">Last name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form>";
	}
	
	@RequestMapping(value = "/user_greeting", method = RequestMethod.GET	 )
	public String printUser(@RequestParam String fname, @RequestParam String lname) {
		return "Hello there! " + fname +" "+ lname;
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET	 )
	public String getOrder(@PathVariable int id) {
		return "Order id: " +id;
	}
}
