package com.example.CustosdeProducao.Projection.DTOS;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProdUpdateDTO {

    private Long id;

    @NotEmpty(message = "O cliente não pode estar vazio!")
    private String cliente;

    @NotNull(message = "O valor não pode estar nulo!")
    private BigDecimal valor;

    @NotNull(message = "A data não pode estar nula!")
    private LocalDate data;

    @NotEmpty(message = "A descrição não pode estar vazia!")
    @Size(max = 250, message = "A descrição não pode exceder 250 caracteres!")
    private String descricao;

    public ProdUpdateDTO() {}

    public ProdUpdateDTO(Long id, String cliente, BigDecimal valor, LocalDate data, String descricao) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }
}
