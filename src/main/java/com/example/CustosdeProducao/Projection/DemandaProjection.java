package com.example.CustosdeProducao.Projection;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface DemandaProjection {
    Long getId();
    Integer getQtdProducao();
    Integer getQtdDia();
    LocalDate getPrazoEstimado();
    BigDecimal getValorEstimado();
}
