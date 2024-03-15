package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Quartos;

public interface QuartosRepository extends MongoRepository<Quartos, String>{
    
}
