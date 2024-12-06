package com.example.CustosdeProducao.Projection.DTOS;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DemandaCreateDTO {

    @NotNull(message = "A quantidade de produção não pode ser nula!")
    private Integer qtdProducao;

    @NotNull(message = "A quantidade de dias não pode ser nula!")
    private Integer qtdDia;

    @NotNull(message = "O prazo estimado não pode ser nulo!")
    private LocalDate prazoEstimado;

    @NotNull(message = "O valor estimado não pode ser nulo!")
    private BigDecimal valorEstimado;

    public DemandaCreateDTO() {}

    public DemandaCreateDTO(Integer qtdProducao, Integer qtdDia, LocalDate prazoEstimado, BigDecimal valorEstimado) {
        this.qtdProducao = qtdProducao;
        this.qtdDia = qtdDia;
        this.prazoEstimado = prazoEstimado;
        this.valorEstimado = valorEstimado;
    }
}
