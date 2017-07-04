package com.biswajit.spring.boot.mybatis.view;

import org.springframework.http.HttpStatus;

/**
 * @author Biswajit Mohapatra
 * 
 */

public class Response {
	
	private HttpStatus status;
	private String message;
		
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
