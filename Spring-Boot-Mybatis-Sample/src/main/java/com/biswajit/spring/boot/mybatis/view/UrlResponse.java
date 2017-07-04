package com.biswajit.spring.boot.mybatis.view;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Biswajit Mohapatra
 * 
 */

public class UrlResponse {
	
	private String url;
	private RequestMethod type;
	private String purpose;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public RequestMethod getType() {
		return type;
	}
	public void setType(RequestMethod type) {
		this.type = type;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	

}
