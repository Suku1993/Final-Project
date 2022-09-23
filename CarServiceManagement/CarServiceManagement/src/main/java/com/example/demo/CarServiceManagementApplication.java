package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({ "com.example" })
@EntityScan(basePackages = { "com.example.entity" })
@EnableJpaRepositories("com.example.dao")
public class CarServiceManagementApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CarServiceManagementApplication.class, args);

	}

}
