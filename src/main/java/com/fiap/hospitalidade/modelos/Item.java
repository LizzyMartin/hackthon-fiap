package com.fiap.hospitalidade.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document("itens")
@NoArgsConstructor
public class Item {

    @Id
    private String id;
    private String nome;
    private Double valor;

    public Item(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

}
