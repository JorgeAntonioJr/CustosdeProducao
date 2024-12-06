package com.example.CustosdeProducao.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "demanda")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private Integer qtdProducao;

    @Column(nullable = false)
    @NotNull
    private Integer qtdDia;

    @Column(nullable = false)
    @NotNull
    private LocalDate prazoEstimado;

    @Column(nullable = false)
    @NotNull
    private BigDecimal valorEstimado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getqtdProducao() {
        return qtdProducao;
    }

    public void setqtdProducao(Integer qtdProducao) {
        this.qtdProducao = qtdProducao;
    }

    public Integer getQtdDia() {
        return qtdDia;
    }

    public void setQtdDia(Integer qtdDia) {
        this.qtdDia = qtdDia;
    }

    public LocalDate getPrazoEstimado() {
        return prazoEstimado;
    }

    public void setPrazoEstimado(LocalDate prazoEstimado) {
        this.prazoEstimado = prazoEstimado;
    }

    public BigDecimal getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(BigDecimal valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

}



