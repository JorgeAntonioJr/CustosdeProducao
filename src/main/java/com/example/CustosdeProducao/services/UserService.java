package com.example.CustosdeProducao.services;

import com.example.CustosdeProducao.Security.UserSpringSecurity;
import com.example.CustosdeProducao.models.ProfileEnum;
import com.example.CustosdeProducao.models.Usuarios;
import com.example.CustosdeProducao.repositories.UsersRepository;
import com.example.CustosdeProducao.services.Exceptions.AuthorizationException;
import com.example.CustosdeProducao.services.Exceptions.DataBindingViolationException;
import com.example.CustosdeProducao.services.Exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UsersRepository usersRepository;

    public UserService(UsersRepository cpRepository) {
        this.usersRepository = cpRepository;
    }

    public Usuarios findById(Long id) {
        UserSpringSecurity userSpringSecurity = authenticated();
        if (Objects.nonNull(userSpringSecurity) &&
                !userSpringSecurity.hasRole(ProfileEnum.ADMIN) &&
                !id.equals(userSpringSecurity.getId())) {
            throw new AuthorizationException("Acesso negado");
        }

        return this.usersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id));
    }

    @Transactional
    public Usuarios create(Usuarios obj) {
        obj.setId(null);
        obj.setSenha(this.bCryptPasswordEncoder.encode(obj.getSenha()));
        obj.setProfile(Collections.singleton(ProfileEnum.USER));

        return usersRepository.save(obj);
    }

    @Transactional
    public Usuarios update(Usuarios obj) {
        Usuarios existingObj = findById(obj.getId());
        existingObj.setUsuario(obj.getUsuario());

        if (obj.getSenha() != null && !obj.getSenha().isEmpty()) {
            existingObj.setSenha(this.bCryptPasswordEncoder.encode(obj.getSenha()));
        }

        return this.usersRepository.save(existingObj);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            usersRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir pois há entidades relacionadas.");
        }
    }

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}




