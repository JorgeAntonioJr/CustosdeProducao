package com.example.CustosdeProducao.Projection.DTOS;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsumoUpdateDTO {

    private Long id;  // O ID é necessário para a atualização

    @NotNull(message = "O tipo de máquina não pode ser nulo!")
    private String tipoMaquina;

    @NotNull(message = "A quantidade de pedras não pode ser nula!")
    private Integer pedras;

    @NotNull(message = "A quantidade de caixas de linha não pode ser nula!")
    private Integer caixasLine;

    // Construtor padrão
    public ConsumoUpdateDTO() {}

    // Construtor com argumentos
    public ConsumoUpdateDTO(Long id, String tipoMaquina, Integer pedras, Integer caixasLine) {
        this.id = id;
        this.tipoMaquina = tipoMaquina;
        this.pedras = pedras;
        this.caixasLine = caixasLine;
    }
}
