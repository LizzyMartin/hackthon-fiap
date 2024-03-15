package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
}
