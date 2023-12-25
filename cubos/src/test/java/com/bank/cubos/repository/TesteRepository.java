package com.bank.cubos.repository;

import com.bank.cubos.domain.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class TesteRepository {
    @Autowired
    private ClienteRepository repository;

    private Cliente cliente;

    @BeforeEach
    public void setClienteConfiguration(){
        this.cliente = new Cliente("Charles","Leclerc",new BigDecimal("10.00"));

    }

    @Test
    public void saveCliente(){
        Cliente saveCliente = repository.save(cliente);

        Assertions.assertNotNull(saveCliente);
        Assertions.assertEquals(saveCliente, cliente);
        Assertions.assertNotNull(saveCliente.getId());
    }
    public void findAllCliente(){
        Cliente saveClientes = repository.save(cliente);
        Cliente saveClientes2 = repository.save(cliente);

        List<Cliente> allClientes = repository.findAll();

        Assertions.assertNotNull(allClientes);
        Assertions.assertEquals(allClientes.get(0), saveClientes);

    }

}
