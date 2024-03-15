package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Item;

public interface ItemRepository extends MongoRepository<Item, String>{
    
}
