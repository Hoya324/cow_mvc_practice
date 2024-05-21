package com.cow.cow_mvc_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CowMvcPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowMvcPracticeApplication.class, args);
	}
}
