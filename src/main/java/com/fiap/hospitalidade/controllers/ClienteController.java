package com.fiap.hospitalidade.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hospitalidade.modelos.Cliente;
import com.fiap.hospitalidade.services.ClienteService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(String id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        if (cliente.getId() != null) {
            throw new IllegalArgumentException("ID não deve ser informado para um novo cliente!");
        }
        validateCliente(cliente);
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente cliente) {
        validateCliente(cliente);
        return clienteService.atualizar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(String id) {
        clienteService.deletar(id);
    }

    private void validateCliente(Cliente clienteDto) {
        boolean isBrasil = "Brasil".equals(clienteDto.getPais());
        if (isBrasil && clienteDto.getCpf() == null) {
            throw new IllegalArgumentException("CPF é obrigatório para brasileiros!");
        }
        if (isBrasil && clienteDto.getPassaporte() != null) {
            throw new IllegalArgumentException("Passaporte não é permitido para brasileiros!");
        }
        if (!isBrasil && clienteDto.getPassaporte() == null) {
            throw new IllegalArgumentException("Passaporte é obrigatório para estrangeiros!");
        }
        if (!isBrasil && clienteDto.getCpf() != null) {
            throw new IllegalArgumentException("CPF não é permitido para estrangeiros!");
        }
    }
    
}
