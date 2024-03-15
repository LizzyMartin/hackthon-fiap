package com.fiap.hospitalidade.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.hospitalidade.dto.ReservaDto;
import com.fiap.hospitalidade.modelos.Cliente;
import com.fiap.hospitalidade.modelos.Reserva;
import com.fiap.hospitalidade.services.ClienteService;
import com.fiap.hospitalidade.services.EmailService;
import com.fiap.hospitalidade.services.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ClienteService clienteService;
    private final EmailService emailService;

    public ReservaController(ReservaService reservaService, ClienteService clienteService, EmailService emailService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
        this.emailService = emailService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Reserva> criarReserva(@RequestBody ReservaDto reservaDto) {
        Cliente cliente = clienteService.buscarPorId(reservaDto.getClienteId());
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado");
        }
        Reserva reserva = reservaService.criarReserva(reservaDto);
        emailService.enviarEmailReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        List<Reserva> reservas = reservaService.buscarTodas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable String id) {
        Reserva reserva = reservaService.buscarPorId(id);
        if (reserva == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada");
        }
        return ResponseEntity.ok(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable String id, @RequestBody ReservaDto reservaDto) {
        Reserva reserva = reservaService.atualizarReserva(reservaDto, id);
        if (reserva == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada");
        }
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable String id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }

}
