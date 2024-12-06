package com.example.CustosdeProducao.Projection.DTOS;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaquinaUpdateDTO {

    private Long id;

    @NotNull(message = "O nome da máquina não pode ser nulo!")
    private String nome;

    @NotNull(message = "O tipo da máquina não pode ser nulo!")
    private String tipo;

    @NotNull(message = "O custo de manutenção não pode ser nulo!")
    private BigDecimal custoManutencao;

    public MaquinaUpdateDTO() {}

    public MaquinaUpdateDTO(Long id, String nome, String tipo, BigDecimal custoManutencao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.custoManutencao = custoManutencao;
    }
}

