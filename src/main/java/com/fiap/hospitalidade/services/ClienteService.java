package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Cliente;
import com.fiap.hospitalidade.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente atualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletar(String id) {
        clienteRepository.deleteById(id);
    }
    
}
