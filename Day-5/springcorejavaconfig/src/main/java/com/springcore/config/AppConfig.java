package com.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcore.model.Address;
import com.springcore.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {

        return new Address(
                "Bhopal",
                "Madhya Pradesh");
    }

    @Bean
    public Student student() {

        return new Student(
                101,
                "Suraj Kumar",
                address());
    }

}