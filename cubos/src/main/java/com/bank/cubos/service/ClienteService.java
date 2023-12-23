package com.bank.cubos.service;

import com.bank.cubos.domain.Cliente;
import com.bank.cubos.domain.DTO.ClienteDTO;
import com.bank.cubos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveClient(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.nome());
        cliente.setSobreNome(clienteDTO.sobreNome());
        cliente.setParticipacao(clienteDTO.participacao());

        if (cliente == null){
            throw new NullPointerException();
        }

       return clienteRepository.save(cliente);
    }
    public List<Cliente> listAllCliente(){

        List<Cliente> allClientes = clienteRepository.findAll();

        if(allClientes == null){
            throw new NullPointerException();
        }
        return allClientes;
    }
}
