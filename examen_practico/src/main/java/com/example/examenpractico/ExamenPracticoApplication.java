package com.example.examenpractico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages  = {"com.example.examenpractico"})
public class ExamenPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenPracticoApplication.class, args);
	}

}
