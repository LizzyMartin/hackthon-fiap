package com.fiap.hospitalidade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Reserva;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ClienteService clienteService;

    public void enviarEmailReserva(Reserva reserva) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(clienteService.buscarPorId(reserva.getClienteId()).getEmail());
        message.setSubject("Confirmação de Reserva");
        message.setText(gerarTextoReserva(reserva));
        mailSender.send(message);
    }

    private String gerarTextoReserva(Reserva reserva) {
        return "Reserva confirmada!";
    }
}
