package com.fiap.hospitalidade.modelos;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document("predio")
@NoArgsConstructor
public class Predio {

    @Id
    private String id;

    private String localidade_id;
    private String nome;
    private LocalDate dataCriacao = LocalDate.now();

    public Predio(String localidade_id, String nome) {
        this.localidade_id = localidade_id;
        this.nome = nome;
    }
    
}
