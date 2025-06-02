package com.teste.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DataFormatter {

    LocalDateTime now = LocalDateTime.now(); //Busca o horário atual do sistema
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy'T'HH:mm:ss", new Locale("pt", "BR"));

    public String formatador = formatter.format(now);

}