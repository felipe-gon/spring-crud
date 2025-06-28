package com.teste.crud.dto;

import com.teste.crud.model.CheckinModel;
import org.springframework.beans.BeanUtils;

public class TotalGastoDTO {
    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TotalGastoDTO(CheckinModel totalGastoDTO) {
        BeanUtils.copyProperties(totalGastoDTO, this);
    }

    public TotalGastoDTO(){
    }

    public TotalGastoDTO(double valorTotal){
        this.valorTotal = valorTotal;
    }
}