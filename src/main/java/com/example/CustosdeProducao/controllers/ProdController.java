package com.example.CustosdeProducao.controllers;

import com.example.CustosdeProducao.models.Producao;
import com.example.CustosdeProducao.services.ProdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producao")
public class ProdController {

    private final ProdService prodService;

    public ProdController(ProdService prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Endpoint funcionando!");
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.OK)
    public ResponseEntity<Producao> findById(@PathVariable Long id) {
        Producao obj = this.prodService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producao create(@Valid @RequestBody Producao obj) {
        Producao created = this.prodService.create(obj);
        return created;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Producao obj, @PathVariable Long id) {
        obj.setId(id);
        this.prodService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.prodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
