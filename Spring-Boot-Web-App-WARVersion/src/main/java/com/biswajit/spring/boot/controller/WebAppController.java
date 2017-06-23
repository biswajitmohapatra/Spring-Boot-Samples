package com.biswajit.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Biswajit Mohapatra
 * 
 */
@Controller
public class WebAppController {

@RequestMapping("/")
public String home(Model model){
	
	model.addAttribute("message", "Biswajit Mohapatra");
	return "index";
}
	
}
