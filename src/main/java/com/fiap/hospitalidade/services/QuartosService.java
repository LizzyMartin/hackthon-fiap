package com.fiap.hospitalidade.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.hospitalidade.modelos.Quartos;
import com.fiap.hospitalidade.modelos.Reserva;
import com.fiap.hospitalidade.repositories.QuartosRepository;
import com.fiap.hospitalidade.repositories.ReservaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class QuartosService {
    
    private final QuartosRepository quartosRepository;
    private final ReservaRepository reservaRepository;

    public QuartosService(QuartosRepository quartosRepository, ReservaRepository reservaRepository) {
        this.quartosRepository = quartosRepository;
        this.reservaRepository = reservaRepository;
    }

    public Iterable<Quartos> getAllQuartos() {
        return quartosRepository.findAll();
    }

    public Quartos getQuartoById(String id) {
        return quartosRepository.findById(id).get();
    }

    public void salvar(Quartos quarto) {
        quartosRepository.save(quarto);
    }

    public void deletar(String id) {
        quartosRepository.deleteById(id);
    }

    public boolean verificarDisponibilidade(String quartoId, LocalDate dataEntrada, LocalDate dataSaida) {
        // Verifique se o quarto existe
        Quartos quarto = quartosRepository.findById(quartoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quarto não encontrado"));

        // Verifique se o quarto já está reservado para as datas desejadas
        List<Reserva> reservas = reservaRepository.findByIdAndDataEntradaAndDataSaida(quartoId, dataEntrada, dataSaida);
        Integer totalQuartosDisponiveis = quarto.getQuantidadeQuartos();
        for (Reserva reserva : reservas) {
            totalQuartosDisponiveis -= reserva.getTotalPessoas();
        }

        return totalQuartosDisponiveis > 0;
    }

}
