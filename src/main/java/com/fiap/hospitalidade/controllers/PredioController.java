package com.fiap.hospitalidade.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hospitalidade.modelos.Predio;
import com.fiap.hospitalidade.services.PredioService;

import java.util.List;

@RestController
@RequestMapping("/predios")
public class PredioController {

    private final PredioService predioService;

    public PredioController(PredioService predioService) {
        this.predioService = predioService;
    }

    @GetMapping
    public List<Predio> findAll() {
        return predioService.findAll();
    }

    @GetMapping("/{id}")
    public Predio findById(String id) {
        return predioService.findById(id);
    }

    @PostMapping
    public Predio save(Predio predio) {
        if (predio.getId() != null) {
            throw new IllegalArgumentException("Id must be null");
        }
        return predioService.save(predio);
    }

    @DeleteMapping("/{id}")
    public void delete(String id) {
        predioService.delete(id);
    }

    @PutMapping("/{id}")
    public Predio update(String id, Predio predio) {
        return predioService.update(id, predio);
    }
    
}
