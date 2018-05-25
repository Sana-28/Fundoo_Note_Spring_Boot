package com.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
<<<<<<< HEAD
	    SecurityAutoConfiguration.class})
=======
		   SecurityAutoConfiguration.class})
>>>>>>> cab15fd899c58b94bca5aab4dd9a0a17fba0a01c
public class FundoonoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundoonoteApplication.class, args);
	}
}
