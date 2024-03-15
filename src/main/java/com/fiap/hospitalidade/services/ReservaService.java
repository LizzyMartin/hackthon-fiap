package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.dto.ReservaDto;
import com.fiap.hospitalidade.modelos.Quartos;
import com.fiap.hospitalidade.modelos.Reserva;
import com.fiap.hospitalidade.repositories.ReservaRepository;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final QuartosService quartoService;
    private final ServicoService servicoService;
    private final ItemService itemService;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
        this.quartoService = null;
        this.servicoService = null;
        this.itemService = null;
    }

    public ReservaService(ReservaRepository reservaRepository, QuartosService quartoService,
            ServicoService servicoService, ItemService itemService) {
        this.reservaRepository = reservaRepository;
        this.quartoService = quartoService;
        this.servicoService = servicoService;
        this.itemService = itemService;
    }

    public Reserva criarReserva(ReservaDto reservaDto) {

        var quartoId = reservaDto.getQuartoId();
        var disponivel = this.quartoService.verificarDisponibilidade(quartoId, reservaDto.getDataEntrada(),
                reservaDto.getDataSaida());
        if (!disponivel) {
            throw new RuntimeException("Quarto não disponível");
        }

        Reserva reserva = new Reserva();
        reserva.setClienteId(reservaDto.getClienteId());
        reserva.setDataEntrada(reservaDto.getDataEntrada());
        reserva.setDataSaida(reservaDto.getDataSaida());
        reserva.setTotalPessoas(reservaDto.getTotalPessoas());
        reserva.setQuartoId(reservaDto.getQuartoId());
        reserva.setServicosOpcionais(reservaDto.getServicosOpcionais());
        reserva.setValorTotal(calcularValorTotal(reservaDto));
        return reservaRepository.save(reserva);
    }

    public double calcularValorTotal(ReservaDto reservaDto) {
        double total = 0.0;

        Quartos quarto = quartoService.getQuartoById(reservaDto.getQuartoId());
        if (quarto != null) {
            total += quarto.getValorDiaria()
                    * ChronoUnit.DAYS.between(reservaDto.getDataEntrada(), reservaDto.getDataSaida());
        }

        for (String servicoOpcionalId : reservaDto.getServicosOpcionais()) {
            var servicos = servicoService.findAll();
            for (var servico : servicos) {
                if (servico.getId().equals(servicoOpcionalId)) {
                    total += servico.getValor();
                }
            }

            var itens = itemService.findAll();
            for (var item : itens) {
                if (item.getId().equals(servicoOpcionalId)) {
                    total += item.getValor();
                }
            }
        }

        return total;
    }

    public void deletarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    public Reserva buscarPorId(String id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> buscarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva atualizarReserva(ReservaDto reservaDto, String id) {
        Reserva reserva = buscarPorId(id);
        if (reserva == null) {
            return null;
        }
        reserva.setClienteId(reservaDto.getClienteId());
        reserva.setDataEntrada(reservaDto.getDataEntrada());
        reserva.setDataSaida(reservaDto.getDataSaida());
        reserva.setTotalPessoas(reservaDto.getTotalPessoas());
        reserva.setQuartoId(reservaDto.getQuartoId());
        reserva.setServicosOpcionais(reservaDto.getServicosOpcionais());
        reserva.setValorTotal(calcularValorTotal(reservaDto));
        return reservaRepository.save(reserva);
        
    }

}
