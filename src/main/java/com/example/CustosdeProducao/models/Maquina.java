package com.example.CustosdeProducao.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "maquina")
@Data
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(length = 255, nullable = false)
    @NotNull
    private String nome;

    @Column(length = 100, nullable = false)
    @NotNull
    private String tipo;

    @Column(nullable = false)
    @NotNull
    private BigDecimal custoManutencao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCustoManutencao() {
        return custoManutencao;
    }

    public void setCustoManutencao(BigDecimal custoManutencao) {
        this.custoManutencao = custoManutencao;
    }
}
