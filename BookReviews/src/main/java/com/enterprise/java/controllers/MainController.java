package com.enterprise.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/denied")
	public String denied(){
	return "denied";
	}

}
