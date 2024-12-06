package com.example.CustosdeProducao.Projection;

import java.math.BigDecimal;

public interface MaquinaProjection {
    Long getId();
    String getNome();
    String getTipo();
    BigDecimal getCustoManutencao();
}
