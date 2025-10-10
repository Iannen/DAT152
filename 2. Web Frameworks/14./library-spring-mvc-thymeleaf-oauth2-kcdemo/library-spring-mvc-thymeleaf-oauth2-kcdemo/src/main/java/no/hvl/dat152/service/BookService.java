/**
 * 
 */
package no.hvl.dat152.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import no.hvl.dat152.model.Book;

/**
 * @author tdoy
 */
@Service
public class BookService {
	
	@Autowired
	private AccessTokenBean accessTokenBean;
	
	private final RestTemplate restclient = new RestTemplate();
	
	public List<Book> findAll(String endpoint){
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(accessTokenBean.getAccessToken());		// Bearer Access Token to access protected resource
			headers.set("Accept", "application/json");
			
			HttpEntity<Void> entity = new HttpEntity<>(headers);
			
			ResponseEntity<List<Book>> response = restclient.exchange(
					endpoint, 
					HttpMethod.GET, 
					entity, new ParameterizedTypeReference<List<Book>>() {}
			);
			
			List<Book> books = response.getBody();
			
			System.out.println("Response from "+endpoint+":\n"+books);
			
			return books;
			
		}catch(Exception e) {
			//
		}
		
		return new ArrayList<Book>();
	}

}
