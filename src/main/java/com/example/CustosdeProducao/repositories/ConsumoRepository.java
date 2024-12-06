package com.example.CustosdeProducao.repositories;

import com.example.CustosdeProducao.models.Consumo;
import com.example.CustosdeProducao.Projection.ConsumoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {

    @Query("SELECT c FROM Consumo c WHERE c.pedras > ?1")
    List<ConsumoProjection> findConsumoWithMinPedras(Integer pedras);

    List<ConsumoProjection> findAllProjectedBy();
}
