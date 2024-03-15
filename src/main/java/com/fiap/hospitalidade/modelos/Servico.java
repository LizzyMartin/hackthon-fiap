package com.fiap.hospitalidade.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document("servicos")
@NoArgsConstructor
public class Servico {

    @Id
    private String id;
    private String nome;
    private Double valor;

    public Servico(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
}
