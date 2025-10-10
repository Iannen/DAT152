/**
 * 
 */
package no.hvl.dat152.auth;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.service.AccessTokenBean;
import no.hvl.dat152.service.AccessTokenRetriever;

/**
 * 
 */
@Component
public class KeycloakTokenFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakTokenFilter.class);
	
	@Autowired
	private AccessTokenRetriever accessTokenRetriever;
	
	@Autowired
	private AccessTokenBean accessTokenBean;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String access_token = accessTokenRetriever.getAccessToken().getTokenValue();
			
			System.out.println("Access Token: " + access_token);
			accessTokenBean.setAccessToken(access_token); 			// set the access token
			
		}catch(Exception e) {
			LOGGER.error("Failed to retrieve access token: {}", e.getMessage());
		}
		
		filterChain.doFilter(request, response);

	}

}
