/**
 * 
 */
package no.hvl.dat152.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;


/**
 * 
 */

@Configuration
public class AccessTokenRetriever {

    private final OAuth2AuthorizedClientService authorizedClientService;
    
    public AccessTokenRetriever(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }
    
    public OAuth2AccessToken getAccessToken() {
    	try {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication instanceof OAuth2AuthenticationToken oauth2Authentication) {
	            String clientRegistrationId = oauth2Authentication.getAuthorizedClientRegistrationId();
	            OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
	                clientRegistrationId, oauth2Authentication.getName());
	            
	            if (authorizedClient != null) {
	                OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
	
	                return accessToken;
	            }
	        }
    	}catch(Exception e) {
    		System.out.println("Error retrieving access token: " + e.getMessage());
    	}
    	
    	return null;
    }

}
