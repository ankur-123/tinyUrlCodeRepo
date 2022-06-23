package com.test.pojos;

import java.util.List;

public class Users {

	
	private int userId;
	private String name;
	private List<String> listOfUrls;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getListOfUrls() {
		return listOfUrls;
	}
	public void setListOfUrls(List<String> listOfUrls) {
		this.listOfUrls = listOfUrls;
	}
	
	
	public Users(int userId, String name, List<String> listOfUrls) {
		super();
		this.userId = userId;
		this.name = name;
		this.listOfUrls = listOfUrls;
	}
	
}
