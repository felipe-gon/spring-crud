package com.teste.crud;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DataFormatter {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy'T'HH:mm:ss", new Locale("pt", "BR"));

    public String formatarData(LocalDateTime data){
        return data.format(formatter);
    }

    public String getDiaDaSemana(LocalDateTime data){
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        return dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, new Locale("pt", "BR")); //Para formatar o dia da semana em Português
    }

}