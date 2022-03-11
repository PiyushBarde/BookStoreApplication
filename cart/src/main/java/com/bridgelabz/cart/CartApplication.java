package com.bridgelabz.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
		log.info("Cart from book store app started");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
