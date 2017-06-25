package com.biswajit.spring.boot.bean;

/**
 * @author Biswajit Mohapatra
 *
 */
public class ProfileBean {
	
	private String name;

	public ProfileBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
