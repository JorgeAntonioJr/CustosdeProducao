package com.example.CustosdeProducao.Projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProdProjection {
    Long getId();
    String getCliente();
    BigDecimal getValor();
    LocalDate getData();
    String getDescricao();
}
