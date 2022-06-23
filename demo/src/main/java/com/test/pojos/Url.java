package com.test.pojos;

import java.sql.Timestamp;

public class Url {

	private Integer id;
	private String actualUrl;
	private String tinyUrl;
	private Timestamp creationTime;
	private Long ttl;     // expiration time
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActualUrl() {
		return actualUrl;
	}
	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}
	public String getTinyUrl() {
		return tinyUrl;
	}
	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	public Long getTtl() {
		return ttl;
	}
	public void setTtl(Long ttl) {
		this.ttl = ttl;
	}
	
	
	public Url(Integer id, String actualUrl, String tinyUrl, Timestamp creationTime, Long ttl) {
		super();
		this.id = id;
		this.actualUrl = actualUrl;
		this.tinyUrl = tinyUrl;
		this.creationTime = creationTime;
		this.ttl = ttl;
	}
	public Url() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
