package com.fiap.hospitalidade.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hospitalidade.modelos.Item;
import com.fiap.hospitalidade.modelos.Servico;
import com.fiap.hospitalidade.services.ItemService;
import com.fiap.hospitalidade.services.ServicoService;

import java.util.List;

@RestController
@RequestMapping("/servico-opcionais")
public class ServicoOpcionaisController {

    private final ItemService itemService;

    private final ServicoService servicoService;

    public ServicoOpcionaisController(ItemService itemService, ServicoService servicoService) {
        this.itemService = itemService;
        this.servicoService = servicoService;
    }

    @GetMapping("/servicos")
    public List<Servico> findAll() {
        return servicoService.findAll();
    }

    @GetMapping("/servicos/{id}")
    public Servico findById(@PathVariable String id) {
        return servicoService.findById(id);
    }

    @PostMapping("/servicos")
    public Servico save(Servico servico) {
        if (servico.getId() != null) {
            throw new IllegalArgumentException("Id must be null");
        }
        return servicoService.save(servico);
    }

    @DeleteMapping("/servicos/{id}")
    public void delete(String id) {
        servicoService.delete(id);
    }

    @PutMapping("/servicos/{id}")
    public Servico update(String id, Servico servico) {
        return servicoService.update(id, servico);
    }

    @GetMapping("/itens")
    List<Item> findAllItens() {
        return itemService.findAll();
    }

    @GetMapping("/itens/{id}")
    Item findByIdItem(@PathVariable String id) {
        return itemService.findById(id);
    }

    @PostMapping("/itens")
    Item saveItem(Item item) {
        if (item.getId() != null) {
            throw new IllegalArgumentException("Id must be null");
        }
        return itemService.save(item);
    }

    @DeleteMapping("/itens/{id}")
    void deleteItem(String id) {
        itemService.delete(id);
    }

    @PutMapping("/itens/{id}")
    Item updateItem(String id, Item item) {
        return itemService.update(id, item);
    }

}
