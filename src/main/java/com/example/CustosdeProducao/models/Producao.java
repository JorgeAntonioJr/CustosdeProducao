package com.example.CustosdeProducao.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "producao")
@Data
public class Producao {

    public static final String TABLE_NAME = "producao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true)
    private Long id;

    @Column(length = 255, nullable = false)
    @NotEmpty(message = "O cliente não pode estar vazio!")
    private String cliente;

    @Column(nullable = false)
    @NotNull
    private BigDecimal valor;

    @Column(nullable = false)
    @NotNull(message = "A data não pode estar nula!")
    private LocalDate data;

    @Column(nullable = false)
    @NotEmpty(message = "A descrição não pode estar vazia")
    @Size(max = 250, message = "A lista não deve estar vazia!")
    private String descricao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcliente() {
        return cliente;
    }

    public void setcliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

