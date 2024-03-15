package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Servico;
import com.fiap.hospitalidade.repositories.ServicoRepository;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById(String id) {
        return servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void delete(String id) {
        servicoRepository.deleteById(id);
    }

    public Servico update(String id, Servico servico) {
        Servico servicoToUpdate = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servicoToUpdate.setNome(servico.getNome());
        servicoToUpdate.setValor(servico.getValor());
        return servicoRepository.save(servicoToUpdate);
    }

}
