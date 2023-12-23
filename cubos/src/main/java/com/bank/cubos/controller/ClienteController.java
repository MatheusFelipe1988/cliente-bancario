package com.bank.cubos.controller;

import com.bank.cubos.domain.Cliente;
import com.bank.cubos.domain.DTO.ClienteDTO;
import com.bank.cubos.repository.ClienteRepository;
import com.bank.cubos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.saveClient(clienteDTO);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/ListAll")
    public ResponseEntity<List<Cliente>> listAllCliente(){
        List<Cliente> clienteList = clienteService.listAllCliente();
        return ResponseEntity.ok().body(clienteList);
    }
}
