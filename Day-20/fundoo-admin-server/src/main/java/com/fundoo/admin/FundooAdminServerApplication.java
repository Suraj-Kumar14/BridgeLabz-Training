package com.fundoo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class FundooAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooAdminServerApplication.class, args);
	}

}
