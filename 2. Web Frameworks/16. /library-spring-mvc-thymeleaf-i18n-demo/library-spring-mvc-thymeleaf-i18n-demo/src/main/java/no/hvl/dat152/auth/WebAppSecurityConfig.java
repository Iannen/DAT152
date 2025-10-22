/**
 * 
 */
package no.hvl.dat152.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * 
 */

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig {

	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	    	.csrf(csrf -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))) // Disable CSRF protection for /h2-console/**
	        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
	        .authorizeHttpRequests(authorize -> authorize
	        	.requestMatchers("/", "/global", "/css/**").permitAll() // Allow public pages
	        	.requestMatchers(HttpMethod.GET, "/addbook/**", "/deletebook/**").hasRole("ADMIN")  // Only ADMIN role can access /addbooks/** and /deletebooks/**
	        	.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() // Allow access to H2 console
	            .anyRequest().authenticated() // All other requests require authentication
	        )
	        .formLogin(Customizer.withDefaults()); // Use default form login

	    return http.build();
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
	public UserDetailsService userDetailsService() {
    	
    	PasswordEncoder encoder = passwordEncoder();
		UserDetails user = User.withUsername("user")
			.password(encoder.encode("password"))
			.roles("USER")
			.build();
		
		UserDetails admin = User.withUsername("admin")
			.password(encoder.encode("password123"))
			.roles("ADMIN")
			.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
