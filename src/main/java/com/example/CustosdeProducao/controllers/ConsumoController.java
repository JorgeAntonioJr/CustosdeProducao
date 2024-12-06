package com.example.CustosdeProducao.controllers;

import com.example.CustosdeProducao.Projection.ConsumoProjection;
import com.example.CustosdeProducao.services.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;

    @GetMapping("/all")
    public List<ConsumoProjection> getAllConsumos() {
        return consumoService.findAllProjected();
    }

    @GetMapping("/filter")
    public List<ConsumoProjection> getConsumosByMinPedras(@RequestParam Integer pedras) {
        return consumoService.findConsumosWithMinPedras(pedras);
    }
}


