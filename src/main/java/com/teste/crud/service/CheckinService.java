package com.teste.crud.service;

import com.teste.crud.model.CheckinModel;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Service
public class CheckinService {

    public void diariaComGaragem (CheckinModel checkin){ //Cria o metodo para setar o valor da diaria recebendo o checkin como parâmetro
        double valorDiaria;
        double valorGaragem = 0;
        double valorTotal;

        DayOfWeek diaSemana = checkin.getDataEntrada().getDayOfWeek();
        LocalTime horarioSaida = checkin.getDataSaida().toLocalTime();

        //Define que se a diária for em dia de semana (segunda a sexta), o valor será de R$120, e no final de semana R$150
        if (diaSemana.getValue() >= DayOfWeek.MONDAY.getValue() &&
            diaSemana.getValue() <= DayOfWeek.FRIDAY.getValue() &&
            checkin.isVeiculo()) {
            valorDiaria = 120;
            valorGaragem = 15;
        }
        //Valores para finais de semana
        else {
            valorDiaria = 150;
            if (checkin.isVeiculo())
                valorGaragem = 20;
        }
        if (horarioSaida.isAfter(LocalTime.of(16,30))){
            valorDiaria = valorDiaria + 120;

        }
        valorTotal = valorGaragem + valorDiaria;

        checkin.setValorDiaria(valorDiaria);
        checkin.setValorGaragem(valorGaragem);
        checkin.setValorTotal(valorTotal);
        }
    }