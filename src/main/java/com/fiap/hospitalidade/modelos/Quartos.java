package com.fiap.hospitalidade.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Document("quartos")
@NoArgsConstructor
public class Quartos {

    @Id
    private String id;
    
    @Field("_id_predio")
    private String idPredio;

    @Field("_id_localidade")
    private String idLocalidade;

    private String nome;
    private String banheiro;
    
    private Map<String, Integer> outrosMoveis;
    private Integer quantidadeQuartos;
    private Map<String, Integer> totalCamas;
    private Integer totalPessoas;
    private Double valorDiaria;

}
