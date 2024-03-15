package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Localidade;
import com.fiap.hospitalidade.repositories.LocalidadeRepository;

import java.util.List;

@Service
public class LocalidadeService {

    private final LocalidadeRepository localidadeRepository;

    public LocalidadeService(LocalidadeRepository localidadeRepository) {
        this.localidadeRepository = localidadeRepository;
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Localidade findById(String id) {
        return localidadeRepository.findById(id).orElse(null);
    }

    public Localidade save(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public void delete(String id) {
        localidadeRepository.deleteById(id);
    }

    public Localidade update(String id, Localidade localidade) {
        Localidade localidadeAtual = localidadeRepository.findById(id).orElse(null);
        if (localidadeAtual == null) {
            return null;
        }
        localidade.setId(localidadeAtual.getId());
        return localidadeRepository.save(localidade);
    }
    
}
