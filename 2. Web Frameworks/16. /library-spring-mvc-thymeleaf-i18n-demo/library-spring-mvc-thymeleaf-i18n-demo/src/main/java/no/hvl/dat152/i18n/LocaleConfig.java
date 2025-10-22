/**
 * 
 */
package no.hvl.dat152.i18n;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author tdoy
 */

@Configuration
public class LocaleConfig implements WebMvcConfigurer {

    @Bean
    LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		localeResolver.setDefaultTimeZone(TimeZone.getTimeZone("UTC"));
		
		return localeResolver;
	}

    // can as well set this in the application.properties (spring.messages.basename=lang/messages)
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		source.setBasename("lang/messages");
//		
//		return source;
//	}
    
    @Bean
    LocaleChangeInterceptor localeChangeInterceptr() {
		LocaleChangeInterceptor localeChgInterceptor = new LocaleChangeInterceptor();
		localeChgInterceptor.setParamName("locale");									// interceptor intercept request with param=locale, default=locale
		
		return localeChgInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptr());
	}
	
}
