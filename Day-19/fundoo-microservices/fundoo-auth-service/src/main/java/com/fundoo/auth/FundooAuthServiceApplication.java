package com.fundoo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FundooAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooAuthServiceApplication.class, args);
	}

}
