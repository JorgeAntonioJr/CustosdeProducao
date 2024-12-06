package com.example.CustosdeProducao.Projection.DTOS;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class UserCreateDTO {

        @NotNull
        private String username;

        @NotNull
        private String password;

    }