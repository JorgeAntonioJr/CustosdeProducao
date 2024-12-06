package com.example.CustosdeProducao.services;

import com.example.CustosdeProducao.Projection.ConsumoProjection;
import com.example.CustosdeProducao.models.Consumo;
import com.example.CustosdeProducao.repositories.ConsumoRepository;
import com.example.CustosdeProducao.services.Exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    public Consumo findById(Long id) {
        Consumo consumo = consumoRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Consumo não encontrado! Id: " + id + ", Tipo: " + Consumo.class.getName())
        );
        return consumo;
    }

    @Transactional
    public Consumo create(Consumo obj) {
        obj.setId(null);
        return consumoRepository.save(obj);
    }

    @Transactional
    public Consumo update(Consumo obj) {
        Consumo newObj = findById(obj.getId());
        newObj.settipoMaquina(obj.gettipoMaquina());
        newObj.setpedras(obj.getPedras());
        newObj.setCaixasLine(obj.getcaixasLine());
        return consumoRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) throws AccessDeniedException {
        try {
            consumoRepository.deleteById(id);
        } catch (Exception e) {
            throw new AccessDeniedException("Não é possível excluir, pois há entidades relacionadas.");
        }
    }

    public List<Consumo> findAll() {
        return consumoRepository.findAll();
    }

    public List<ConsumoProjection> findAllProjected() {
        return null;
    }

    public List<ConsumoProjection> findConsumosWithMinPedras(Integer pedras) {
        return findAllProjected();
    }
}


