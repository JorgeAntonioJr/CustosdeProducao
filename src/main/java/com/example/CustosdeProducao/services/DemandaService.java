package com.example.CustosdeProducao.services;

import com.example.CustosdeProducao.Projection.DemandaProjection;
import com.example.CustosdeProducao.models.Demanda;
import com.example.CustosdeProducao.repositories.DemandaRepository;
import com.example.CustosdeProducao.services.Exceptions.DataBindingViolationException;
import com.example.CustosdeProducao.services.Exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DemandaService {

    @SuppressWarnings("rawtypes")
    private final DemandaRepository demandaRepository;

    public DemandaService(@SuppressWarnings("rawtypes") DemandaRepository demandaRepository) {
        this.demandaRepository = demandaRepository;
    }

    // Encontrar uma demanda pelo ID
    @SuppressWarnings("unchecked")
    public Demanda findById(Long id) throws Throwable {
        return (Demanda) demandaRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Demanda não encontrada! Id: " + id + ", Tipo: " + Demanda.class.getSimpleName()));
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public Demanda create(Demanda obj) {
        obj.setId(null); // Garante que o ID será gerado automaticamente
        return (Demanda) demandaRepository.save(obj);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public Demanda update(Demanda obj) throws Throwable {
        Demanda existingObj = findById(obj.getId());
        updateData(existingObj, obj);
        return (Demanda) demandaRepository.save(existingObj);
    }

    // Deletar uma demanda pelo ID
    @SuppressWarnings("unchecked")
    @Transactional
    public void delete(Long id) throws Throwable {
        findById(id); // Verifica se a demanda existe
        try {
            demandaRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir, pois há entidades relacionadas.");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Demanda> findAll() {
        return demandaRepository.findAll();
    }

    private void updateData(Demanda target, Demanda source) {
        target.setqtdProducao(source.getqtdProducao());
        target.setQtdDia(source.getQtdDia());
        target.setPrazoEstimado(source.getPrazoEstimado());
        target.setValorEstimado(source.getValorEstimado());
    }

    @SuppressWarnings("unchecked")
    public List<DemandaProjection> findAllProjected() {
        return demandaRepository.findAllProjected();
    }

    @SuppressWarnings("unchecked")
    public List<DemandaProjection> findDemandasWithMinValor(BigDecimal valor) {
        return demandaRepository.findDemandasWithMinValor(valor);
    }
}
