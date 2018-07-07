package com.hackcrown.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class DemoController {
	
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}

}
