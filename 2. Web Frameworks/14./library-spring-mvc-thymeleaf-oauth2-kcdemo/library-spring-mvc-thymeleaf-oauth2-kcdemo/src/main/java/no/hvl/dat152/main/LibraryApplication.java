package no.hvl.dat152.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@Configuration
@EnableJpaRepositories("no.hvl.dat152.repository")
@EntityScan("no.hvl.dat152.model")
@ComponentScan(basePackages = {"no.hvl.dat152.service", 
								"no.hvl.dat152.controller", 
								"no.hvl.dat152.exceptions",
								"no.hvl.dat152.auth"})
public class LibraryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

}
