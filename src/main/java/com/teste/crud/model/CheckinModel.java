package com.teste.crud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_checkin")
@NoArgsConstructor
@AllArgsConstructor

public class CheckinModel {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Getters e Setters
    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isVeiculo() {
        return veiculo;
    }

    public void setVeiculo(boolean veiculo) {
        this.veiculo = veiculo;
    }

    public UsuarioModel getPessoa() {
        return pessoa;
    }

    public void setPessoa(UsuarioModel pessoa) {
        this.pessoa = pessoa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorGaragem() {
        return valorGaragem;
    }

    public void setValorGaragem(double valorGaragem) {
        this.valorGaragem = valorGaragem;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel pessoa;    //Atributo que vai vincular meu checkin ao meu usuario na hora de fazer o POST checkin

    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    LocalDateTime dataEntrada;
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    LocalDateTime dataSaida;
    boolean veiculo;
    double valorDiaria;
    double valorTotal;
    double valorGaragem;

}
