package com.teste.crud.service;

import com.teste.crud.DataFormatter;
import com.teste.crud.model.CheckinModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class CheckinService {

    @Autowired
    DataFormatter dataFormatter;

    public void diariaSegundaSexta (CheckinModel checkin){ //Cria o metodo para setar o valor da diaria recebendo o checkin inteiro como parâmetro

    }

    
}