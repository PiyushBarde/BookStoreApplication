package com.bridgelabz.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class UserregistrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserregistrationApplication.class, args);
		log.info("User Registration App started");
	}
}
