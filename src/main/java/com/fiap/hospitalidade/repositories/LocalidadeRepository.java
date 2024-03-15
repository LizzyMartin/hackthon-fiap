package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Localidade;

public interface LocalidadeRepository extends MongoRepository<Localidade, String>{
    
}
