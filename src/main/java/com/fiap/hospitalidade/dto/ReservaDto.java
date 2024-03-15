package com.fiap.hospitalidade.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservaDto {

    private String clienteId;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Integer totalPessoas;
    private String quartoId;
    private List<String> servicosOpcionais;

}
