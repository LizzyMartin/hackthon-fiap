package com.fiap.hospitalidade.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("localidade")
public class Localidade {

    @Id
    private String id;

    private String endereco_id;
    private List<String> amenidades;
    private LocalDate dataCriacao = LocalDate.now();

    public Localidade() {
    }

    public Localidade(String endereco_id, List<String> amenidades) {
        this.endereco_id = endereco_id;
        this.amenidades = amenidades;
    }

}
