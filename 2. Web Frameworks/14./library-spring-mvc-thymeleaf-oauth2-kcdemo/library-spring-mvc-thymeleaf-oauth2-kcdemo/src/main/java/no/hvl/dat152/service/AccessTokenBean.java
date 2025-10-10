/**
 * 
 */
package no.hvl.dat152.service;

import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
public class AccessTokenBean {

	private String accessToken;
	
	public AccessTokenBean() {
		//default
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
}
