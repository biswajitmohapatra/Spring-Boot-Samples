package com.biswajit.spring.boot.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.spring.boot.email.service.EmailService;

/**
 * @author Biswajit Mohapatra
 *
 */
@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String emailNotification(){
		String message ="";
		String from ="email id";
		String to ="email id";
		String subject = "Test mail";
		String body = "This is just a simple test mail.Please disregard!";
		try {
			emailService.sendEmail(true, from, to, subject, body);
			message = "Email has sent successfully!";
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		
		return message;
	}
	
}
