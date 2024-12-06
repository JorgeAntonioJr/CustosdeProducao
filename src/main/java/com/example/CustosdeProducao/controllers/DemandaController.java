package com.example.CustosdeProducao.controllers;

import com.example.CustosdeProducao.Projection.DemandaProjection;
import com.example.CustosdeProducao.services.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/demanda")
public class DemandaController {

    @Autowired
    private DemandaService demandaService;

    @GetMapping("/all")
    public List<DemandaProjection> getAllDemandas() {
        return demandaService.findAllProjected();
    }

    @GetMapping("/filter")
    public List<DemandaProjection> getDemandasByMinValor(@RequestParam BigDecimal valor) {
        return demandaService.findDemandasWithMinValor(valor);
    }
}

