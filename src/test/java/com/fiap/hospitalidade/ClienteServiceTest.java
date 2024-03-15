package com.fiap.hospitalidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fiap.hospitalidade.modelos.Cliente;
import com.fiap.hospitalidade.repositories.ClienteRepository;
import com.fiap.hospitalidade.services.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    void salvar_DeveRetornarClienteSalvo() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.salvar(cliente);

        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void buscarPorId_DeveRetornarClienteExistente() {
        String id = "1";
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.buscarPorId(id);

        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    void buscarPorId_DeveRetornarNullQuandoClienteNaoExistir() {
        String id = "1";
        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        Cliente result = clienteService.buscarPorId(id);

        assertEquals(null, result);
        verify(clienteRepository, times(1)).findById(id);
    }

    @Test
    void buscarTodos_DeveRetornarListaDeClientes() {
        List<Cliente> clientes = new ArrayList<>();
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.buscarTodos();

        assertEquals(clientes, result);
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void atualizar_DeveRetornarClienteAtualizado() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.atualizar(cliente);

        assertEquals(cliente, result);
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void deletar_DeveChamarMetodoDeleteById() {
        String id = "1";

        clienteService.deletar(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }
}