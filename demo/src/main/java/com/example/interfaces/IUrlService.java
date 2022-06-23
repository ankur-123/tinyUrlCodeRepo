package com.example.interfaces;

import java.sql.Timestamp;

public interface IUrlService {
	
	public String getTinyUrl(String actualUrl, Timestamp creationTime, Integer userId,Long ttl);
	
	public String getActualUrl(String tinyUrl);
	
	public String generateTinyUrl(String actualUrl,Timestamp creationTime);
	
	public void urlListCleanUpService();
	
}

