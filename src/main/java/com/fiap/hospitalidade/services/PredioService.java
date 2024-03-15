package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Predio;
import com.fiap.hospitalidade.repositories.PredioRepository;

import java.util.List;

@Service
public class PredioService {
    
    private final PredioRepository predioRepository;

    public PredioService(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    public List<Predio> findAll() {
        return predioRepository.findAll();
    }

    public Predio findById(String id) {
        return predioRepository.findById(id).orElse(null);
    }

    public Predio save(Predio predio) {
        return predioRepository.save(predio);
    }

    public void delete(String id) {
        predioRepository.deleteById(id);
    }

    public Predio update(String id, Predio predio) {
        Predio predioAtual = predioRepository.findById(id).orElse(null);
        if (predioAtual == null) {
            return null;
        }
        predio.setId(predioAtual.getId());
        return predioRepository.save(predio);
    }

}
