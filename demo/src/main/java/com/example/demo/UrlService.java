package com.example.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.interfaces.IUrlService;
import com.test.pojos.Url;
import com.test.pojos.Users;

import net.bytebuddy.utility.RandomString;



@Service
public class UrlService implements IUrlService{
	
	
	public int tinyUrlLength = 6;
	public long defaultTTL = 12l;  // 12 hrs
	
	List<Url> urls = new ArrayList<Url>() ;
	List<Users> users = new ArrayList<Users>();
	
	
	/*
	 * getTinyUrl()
	 * 		short: randomString()
	 * 		actualUrl, abc123,ct, ttl,userid  -> db table / List
	 * 		return abc123;
	 * 
	 * 
	 * 1. google.com,abc123,1,12hrs
	 * 2. google.com, abc345,2, 6 hrs
	 * 3. 
	 * 4
	 * 
	 * getActualUrl(abc123)
	 * 		
	 * 	
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	/*
	 * call generate URL method and get url
	 * store it in URL Object., and update in users object
	 * 
	 */
	public String getTinyUrl(String actualUrl, Timestamp creationTime, Integer userId,Long ttl) {
		
		String tinyUrl = generateTinyUrl(actualUrl,creationTime);
		
		if(ttl == null || ttl == 0)
			ttl = defaultTTL;
		
		Url urlData = new Url();
		urlData.setActualUrl(actualUrl);
		urlData.setCreationTime(creationTime);
		urlData.setTinyUrl(tinyUrl);
		
		urlData.setTtl(creationTime.getTime() + ttl * 24 * 3600 * 1000);
		
		urls.add(urlData);
		
		if(userId != 0) {
			Users user = getUser(userId);
			if(user != null) {
				List<String> listofUrlMap = user.getListOfUrls();
				listofUrlMap.add(actualUrl +"##"+ tinyUrl);
				user.setListOfUrls(listofUrlMap);
			}
		}
		return tinyUrl;
		
	}

	public String getActualUrl(String tinyUrl) {
		
		for(Url url : urls) {
			if(url.getTinyUrl().equals(tinyUrl)) {
				return url.getActualUrl();
			}
		}
		
		return null;
	}

	
	public String generateTinyUrl(String actualUrl, Timestamp creationTime) {
			
		String tinyUrl = RandomString.make(tinyUrlLength);	
		return tinyUrl;
		
	}
	
	
	public Users getUser(int userId) {
		for(Users user : users) {
			if(user.getUserId() == userId) {
				return user;
			}
		}
		return null;
	}
	
	
	// Service for cleaning the Urls table (run every 5 min)
	public void urlListCleanUpService() {
		
		Long ts = System.currentTimeMillis();
		int n = urls.size();
		
		for(int i=0;i<n;i++) {
			if(urls.get(i).getTtl() <= ts) {
				urls.remove(i);
			}
		}
	}
	
	
	
	
}
