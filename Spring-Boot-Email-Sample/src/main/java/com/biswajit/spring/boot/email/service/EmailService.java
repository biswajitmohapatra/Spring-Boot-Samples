/**
 * 
 */
package com.biswajit.spring.boot.email.service;

import javax.mail.internet.MimeMessage;

/**
 * @author Biswajit Mohapatra
 *
 */
public interface EmailService {

	public void sendEmail(boolean isHtml,String from,String to,String subject,String body) throws Exception;
	public MimeMessage buildMessage(boolean isHtml,String from,String to,String subject,String body) throws Exception;
}
