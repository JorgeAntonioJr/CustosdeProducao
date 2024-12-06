package com.example.CustosdeProducao.Projection.DTOS;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {

    @NotNull
    private Long id;

   @NotNull
   private String password;

}
