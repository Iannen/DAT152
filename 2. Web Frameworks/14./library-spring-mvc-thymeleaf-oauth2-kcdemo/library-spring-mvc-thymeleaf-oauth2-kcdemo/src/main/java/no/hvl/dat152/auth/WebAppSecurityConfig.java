/**
 * 
 */
package no.hvl.dat152.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;




/**
 * 
 */

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig {
	
	@Autowired
	private KeycloakTokenFilter keycloakTokenFilter;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	        	.requestMatchers("/", "/login", "/css/**").permitAll() 			// Allow public pages and unauthenticated access to CSS, home and login page
	            .anyRequest().authenticated()) 									// All other requests require authentication
	        .oauth2Login(Customizer.withDefaults())								// Enable OAuth2 login with default settings	
	        .logout(logout -> logout
	        		.logoutSuccessHandler(oidcLogoutSuccessHandler())); 		// add logout handle					    	
  
	     http.addFilterAfter(keycloakTokenFilter, AuthorizationFilter.class);
	     
	    return http.build();
	}

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
          new OidcClientInitiatedLogoutSuccessHandler(
            this.clientRegistrationRepository);


        return oidcLogoutSuccessHandler;
    }
    
}
