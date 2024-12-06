package com.example.CustosdeProducao.repositories;

import com.example.CustosdeProducao.Projection.DemandaProjection;
import com.example.CustosdeProducao.models.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("hiding")
public interface DemandaRepository<DemandaProjection> extends JpaRepository<Demanda, Long> {

    @Query("SELECT d FROM Demanda d WHERE d.valorEstimado > ?1")
    List<DemandaProjection> findDemandaWithMinValorEstimado(BigDecimal valor);

    List<DemandaProjection> findAllProjectedBy();

    List<com.example.CustosdeProducao.Projection.DemandaProjection> findAllProjected();

    List<com.example.CustosdeProducao.Projection.DemandaProjection> findDemandasWithMinValor(BigDecimal valor);
}
