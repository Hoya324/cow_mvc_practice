package com.cow.cow_mvc_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@Configuration, @EnableAutoConfiguration, @ComponentScan 3가지를 하나의 애노테이션으로 합친 것
public class CowMvcPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowMvcPracticeApplication.class, args);
	}

}
