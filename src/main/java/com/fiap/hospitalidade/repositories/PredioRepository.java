package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Predio;

public interface PredioRepository extends MongoRepository<Predio, String>{

}
