package com.example.html;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HtmlApplication {

	public static void main(String[] args) {
		System.setProperty("server.port","8081");
		SpringApplication.run(HtmlApplication.class, args);
	}
}
