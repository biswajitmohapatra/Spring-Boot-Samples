/**
 * 
 */
package com.biswajit.spring.boot.email.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Biswajit Mohapatra
 *
 */
@Service(value="emilService")
public class EmailServiceImpl implements EmailService{

	 @Autowired
	 private JavaMailSender sender;
	
	@Override
	public void sendEmail(boolean isHtml, String from, String to, String subject, String body) throws Exception {
	
		MimeMessage message = buildMessage(isHtml,from,to,subject,body);
			
		sender.send(message);
	}

	@Override
	public MimeMessage buildMessage(boolean isHtml,String from, String to, String subject, String body) throws Exception{
		
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(to);
        if(isHtml)
        	helper.setText("<html><body>" + body +  "<body></html>", isHtml);
        else
        	helper.setText(body);
        
        helper.setSubject(subject);
			
        return message;
	}
	
}
