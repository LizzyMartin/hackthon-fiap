package com.fiap.hospitalidade.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hospitalidade.modelos.Quartos;
import com.fiap.hospitalidade.services.QuartosService;

@RestController
@RequestMapping("/quartos")
public class QuartosController {
    
    private final QuartosService quartosService;

    public QuartosController(QuartosService quartosService) {
        this.quartosService = quartosService;
    }

    @GetMapping
    public Iterable<Quartos> getAllQuartos() {
        return quartosService.getAllQuartos();
    }

    @GetMapping("/{id}")
    public Quartos getQuartoById(@PathVariable String id) {
        return quartosService.getQuartoById(id);
    }

    @PostMapping
    public void salvar(@RequestBody Quartos quarto) {
        if (quarto.getId() != null) {
            throw new IllegalArgumentException("Id must be null");
        }
        quartosService.salvar(quarto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        quartosService.deletar(id);
    }

}
