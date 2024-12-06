package com.example.CustosdeProducao.controllers;

import com.example.CustosdeProducao.services.MaquinaService;
import com.example.CustosdeProducao.models.Maquina;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {
    private final MaquinaService maquinaService;

    public MaquinaController(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<Maquina> findById(@PathVariable Long id) {
       Maquina obj = this.maquinaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina create(@Valid @RequestBody Maquina obj) {
        Maquina created = this.maquinaService.create(obj);
        return created;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Maquina obj, @PathVariable Long id) {
        obj.setId(id);
        this.maquinaService.update(obj);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.maquinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

