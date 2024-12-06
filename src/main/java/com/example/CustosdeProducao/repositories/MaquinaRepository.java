package com.example.CustosdeProducao.repositories;

import com.example.CustosdeProducao.models.Maquina;
import com.example.CustosdeProducao.Projection.MaquinaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {

    @Query("SELECT m FROM Maquina m WHERE m.custoManutencao > ?1")
    List<MaquinaProjection> findMaquinasWithMinCustoManutencao(BigDecimal custoMinimo);

    List<MaquinaProjection> findAllProjectedBy();
}
