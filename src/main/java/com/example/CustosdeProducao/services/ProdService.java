package com.example.CustosdeProducao.services;

import com.example.CustosdeProducao.models.Producao;
import com.example.CustosdeProducao.repositories.ProdRepository;
import com.example.CustosdeProducao.services.Exceptions.DataBindingViolationException;
import com.example.CustosdeProducao.services.Exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProdService {

    private final ProdRepository ProdRepository;

    public ProdService(ProdRepository cpRepository) {
        this.ProdRepository = cpRepository;
    }

    public Producao findById(Long id) {
        return this.ProdRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produção não encontrado! Id: " + id));
    }

    @Transactional
    public Producao create(Producao obj) {
        obj.setId(null);
        return ProdRepository.save(obj);
    }

    @Transactional
    public Producao update(Producao obj) {
        Producao existingObj = findById(obj.getId());
        existingObj.setcliente(obj.getcliente());
        existingObj.setData(obj.getData());
        existingObj.setDescricao(obj.getDescricao());
        existingObj.setValor(obj.getValor());
        return this.ProdRepository.save(existingObj);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            ProdRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir pois há entidades relacionadas.");
        }
    }

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class DataIntegrityException extends RuntimeException {
        public DataIntegrityException(String message) {
            super(message);
        }
    }
}
