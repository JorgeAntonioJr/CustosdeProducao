package com.example.CustosdeProducao.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = Usuarios.TABLE_NAME)
@Data
public class Usuarios {

    public static final String TABLE_NAME = "Usuario";

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, length = 100, unique = true)
    @NotNull
    @NotEmpty
    private String usuario;

    @Setter
    @Getter
    @Column(nullable = false, length = 60)
    @NotNull
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @CollectionTable(name = "user_profile")
    @Column(name = "profile", nullable = false)
    private Set<Integer> profile = new HashSet<>();

    public Usuarios() {
        addProfile(ProfileEnum.USER);
    }

    public Set<ProfileEnum> getProfiles() {
        return this.profile.stream()
                .map(ProfileEnum::toEnum)
                .collect(Collectors.toSet());
    }

    public void addProfile(ProfileEnum profileEnum) {
        this.profile.add(profileEnum.getCode());
    }

    public void setProfile(Set<ProfileEnum> profiles) {
        this.profile = profiles.stream()
                .map(ProfileEnum::getCode)
                .collect(Collectors.toSet());
    }
}



