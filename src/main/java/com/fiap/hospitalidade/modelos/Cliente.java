package com.fiap.hospitalidade.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document("clientes")
@NoArgsConstructor
public class Cliente {

    @Id
    @JsonIgnore
    private String id;

    private String pais;
    private String cpf;
    private String passaporte;
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    
}
