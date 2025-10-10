/**
 * 
 */
package no.hvl.dat152.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(@AuthenticationPrincipal OAuth2User principal, Model model, Authentication auth) {
		
		try {
			principal.getAttributes();
		} catch (Exception e) {
			return "index";
		}	
		
		// get user details from OAuth2
		String username = principal.getAttribute("name");
		String email = principal.getAttribute("email");
		
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		
		
		OidcUser user = (OidcUser) auth.getPrincipal();
		String idToken = user.getIdToken().getTokenValue();
		
		System.out.println("ID Token: " + idToken);
		
		// return to home page
		return "index";
	}
	
	@GetMapping("/logoutsuccess")
	public String logout() {
		
		return "logoutsuccess";
	}
	
	
}
