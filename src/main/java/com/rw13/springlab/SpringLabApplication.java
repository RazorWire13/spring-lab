package com.rw13.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLabApplication.class, args);
		System.out.println("http://localhost:8080/hello");
		System.out.println("http://localhost:8080/capitalize/hello?name=heyo%20what%20is%20up%20party%20people");
	}
}
