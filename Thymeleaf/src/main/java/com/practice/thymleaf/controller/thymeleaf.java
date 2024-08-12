package com.practice.thymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.*;

@Controller
public class thymeleaf {
	
	@GetMapping("/about")
	public String practice(Model model) {
		System.out.println("This is about page");
		
		model.addAttribute("name", "Hemant");
		model.addAttribute("secondName", "Abhinash");
	
		return "practice";
	}
}
