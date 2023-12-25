package com.bank.cubos.service;

import com.bank.cubos.domain.Cliente;
import com.bank.cubos.domain.DTO.ClienteDTO;
import com.bank.cubos.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    private Cliente cliente;

    private ClienteDTO clienteDTO;

    @BeforeEach
    public void setUp(){
        cliente = new Cliente("George","Russel",new BigDecimal(10.00));

        clienteDTO = new ClienteDTO("George","Russel",new BigDecimal(10.00));


    }
    @Test
    public void saveTheCliente(){
        when(this.clienteRepository.save(ArgumentMatchers.any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSaved = clienteService.saveClient(clienteDTO);

        Assertions.assertEquals(clienteSaved.getId(),cliente.getId());
        Assertions.assertNotNull(clienteSaved);

    }
    @Test
    public void findAllClientes(){

        List<Cliente> clienteList = new ArrayList<>();

        clienteList.add(cliente);
        clienteList.add(cliente);
        clienteList.add(cliente);

        when(this.clienteRepository.findAll()).thenReturn(clienteList);

        List<Cliente> clienteListReal = clienteService.listAllCliente();

        Assertions.assertNotNull(clienteListReal);
        Assertions.assertEquals(clienteListReal, clienteList);



    }
}
