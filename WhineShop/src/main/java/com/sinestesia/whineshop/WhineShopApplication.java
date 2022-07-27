package com.sinestesia.whineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WhineShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhineShopApplication.class, args);
	}

}
