package com.example.CustosdeProducao.controllers;

import com.example.CustosdeProducao.models.Usuarios;
import com.example.CustosdeProducao.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<Usuarios> findById(@PathVariable Long id) {
        Usuarios obj = this.userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios create(@Valid @RequestBody Usuarios obj) {
        Usuarios created = this.userService.create(obj);
        return created;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Usuarios obj, @PathVariable Long id) {
        obj.setId(id);
        this.userService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}