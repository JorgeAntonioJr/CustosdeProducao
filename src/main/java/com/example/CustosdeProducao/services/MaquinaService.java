package com.example.CustosdeProducao.services;

import com.example.CustosdeProducao.models.Maquina;
import com.example.CustosdeProducao.repositories.MaquinaRepository;
import com.example.CustosdeProducao.services.Exceptions.DataBindingViolationException;
import com.example.CustosdeProducao.services.Exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public Maquina findById(Long id) {
        Optional<Maquina> maquina = maquinaRepository.findById(id);
        return maquina.orElseThrow(() ->
                new ObjectNotFoundException("Máquina não encontrada! Id: " + id + ", Tipo: " + Maquina.class.getName())
        );
    }

    @Transactional
    public Maquina create(Maquina obj) {
        obj.setId(null);
        return maquinaRepository.save(obj);
    }


    @Transactional
    public Maquina update(Maquina obj) {
        Maquina newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setTipo(obj.getTipo());
        newObj.setCustoManutencao(obj.getCustoManutencao());
        return maquinaRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        try {
            maquinaRepository.deleteById(id);
        } catch(Exception e) {
            throw new DataBindingViolationException("Não é possível excluir, pois há entidades relacionadas.");
        }
    }


    public List<Maquina> findAll() {
        return maquinaRepository.findAll();
    }
}
