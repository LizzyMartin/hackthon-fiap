package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Servico;

public interface ServicoRepository extends MongoRepository<Servico, String>{
    
}
