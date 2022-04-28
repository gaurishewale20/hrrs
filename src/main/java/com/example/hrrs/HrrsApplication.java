package com.example.hrrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class HrrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrrsApplication.class, args);
	}

}
