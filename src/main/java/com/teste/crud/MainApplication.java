package com.teste.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		DataFormatter dayOfWeek = new DataFormatter();
		DataFormatter formatter = new DataFormatter();

		System.out.println(formatter.formatarData(LocalDateTime.now()));


		System.out.println(dayOfWeek.getDiaDaSemana(LocalDateTime.now()));
		SpringApplication.run(MainApplication.class, args);
	}

}