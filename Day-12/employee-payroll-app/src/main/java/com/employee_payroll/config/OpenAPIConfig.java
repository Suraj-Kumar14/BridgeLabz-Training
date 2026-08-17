package com.employee_payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI employeePayrollOpenAPI() {

		return new OpenAPI().info(new Info().title("Employee Payroll API").version("1.0")
				.description("REST API for managing employees, departments and payroll data"));
	}
}
