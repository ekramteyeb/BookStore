package com.course.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllers {

	@RequestMapping(value="/index")
	public String index(){
		
		return "index";
	}
}
