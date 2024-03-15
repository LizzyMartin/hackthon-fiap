package com.fiap.hospitalidade.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hospitalidade.services.LocalidadeService;
import com.fiap.hospitalidade.modelos.Localidade;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @GetMapping
    public List<Localidade> findAll() {
        return localidadeService.findAll();
    }

    @GetMapping("/{id}")
    public Localidade findById(String id) {
        return localidadeService.findById(id);
    }

    @PostMapping
    public Localidade save(Localidade localidade) {
        if (localidade.getId() != null) {
            throw new IllegalArgumentException("Id must be null");
        }
        return localidadeService.save(localidade);
    }

    @DeleteMapping("/{id}")
    public void delete(String id) {
        localidadeService.delete(id);
    }

    @PutMapping("/{id}")
    public Localidade update(String id, Localidade localidade) {
        return localidadeService.update(id, localidade);
    }
    
}
