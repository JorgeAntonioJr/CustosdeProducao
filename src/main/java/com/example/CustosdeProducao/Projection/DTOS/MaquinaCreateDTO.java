package com.example.CustosdeProducao.Projection.DTOS;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaquinaCreateDTO {

    @NotNull(message = "O nome da máquina não pode ser nulo!")
    private String nome;

    @NotNull(message = "O tipo da máquina não pode ser nulo!")
    private String tipo;

    @NotNull(message = "O custo de manutenção não pode ser nulo!")
    private BigDecimal custoManutencao;

    public MaquinaCreateDTO() {}

    public MaquinaCreateDTO(String nome, String tipo, BigDecimal custoManutencao) {
        this.nome = nome;
        this.tipo = tipo;
        this.custoManutencao = custoManutencao;
    }
}


