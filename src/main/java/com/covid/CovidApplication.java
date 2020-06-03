package com.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication

public class CovidApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApplication.class, args);
	}

}
