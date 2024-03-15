package com.fiap.hospitalidade.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.hospitalidade.modelos.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    List<Reserva> findByIdAndDataEntradaAndDataSaida(String quartoId, LocalDate dataEntrada, LocalDate dataSaida);
    
}
