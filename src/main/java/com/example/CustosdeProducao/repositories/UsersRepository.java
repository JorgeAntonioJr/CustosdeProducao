package com.example.CustosdeProducao.repositories;

import com.example.CustosdeProducao.models.Usuarios;
import com.example.CustosdeProducao.Projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Usuarios, Long> {

    @Query("SELECT u FROM Usuarios u WHERE u.usuario = ?1")
    List<UserProjection> findUsuariosByUsername(String username);

    List<UserProjection> findAllProjectedBy();
}


