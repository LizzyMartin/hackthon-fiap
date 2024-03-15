package com.fiap.hospitalidade.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document
@NoArgsConstructor
public class Reserva {
    
    @Id
    private String id;
    private Integer totalPessoas;
    private String clienteId;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String quartoId;
    private boolean disponibilidade;
    private List<String> servicosOpcionais;
    private double valorTotal;

}
