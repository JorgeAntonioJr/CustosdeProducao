package com.example.CustosdeProducao.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "consumo")
@Data
public class Consumo {

    public interface Create {}
    public interface Update {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String tipoMaquina;

    @Column(nullable = false)
    @NotNull
    private Integer pedras;

    @Column(nullable = false)
    @NotNull
    private Integer caixasLine;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettipoMaquina() {
        return tipoMaquina;
    }

    public void settipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public Integer getPedras() {
        return pedras;
    }

    public void setpedras(Integer pedras) {
        this.pedras = pedras;
    }

    public Integer getcaixasLine() {
        return caixasLine;
    }

    public void setCaixasLine(Integer caixasLine) {
        this.caixasLine = caixasLine;
    }

}

