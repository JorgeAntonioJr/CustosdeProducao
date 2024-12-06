package com.example.CustosdeProducao.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{bcrypt}$2a$10$someEncryptedPassword")
                    .authorities(Collections.emptyList())
                    .build();
        }

        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}