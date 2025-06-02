package com.teste.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		DataFormatter formatter = new DataFormatter();
		System.out.println(formatter.formatador);
		SpringApplication.run(MainApplication.class, args);
	}

}