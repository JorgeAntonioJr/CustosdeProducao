package com.example.CustosdeProducao.repositories;

import com.example.CustosdeProducao.Projection.ProdProjection;
import com.example.CustosdeProducao.models.Producao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProdRepository extends JpaRepository<Producao, Long> {

    @Query("SELECT p FROM Producao p WHERE p.valor > ?1")
    List<ProdProjection> findProducaoWithMinValor(BigDecimal valor);

    List<ProdProjection> findAllProjectedBy();
}


