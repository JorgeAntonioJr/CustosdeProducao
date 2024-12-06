package com.example.CustosdeProducao.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum ProfileEnum {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private final Integer code;
    private final String description;

    ProfileEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ProfileEnum toEnum(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (ProfileEnum x : ProfileEnum.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + code);
    }
}

