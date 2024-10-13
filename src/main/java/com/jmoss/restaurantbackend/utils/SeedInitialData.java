package com.jmoss.restaurantbackend.utils;

import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedInitialData implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public SeedInitialData(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente01 = new Cliente();
        cliente01.setNombre("Juan");
        cliente01.setApellidos("Perez");
        cliente01.setCorreo("Juan@correo.com");
        cliente01.setEnable(true);
        cliente01.setIdentifier("jperez");
        cliente01.setNit("123");
        cliente01.setRazonSocial("Test SA");
        cliente01.setPassword("123456");


        Cliente cliente02 = new Cliente();
        cliente02.setNombre("Katherine");
        cliente02.setApellidos("Mosquera");
        cliente02.setCorreo("katherine@correo.com");
        cliente02.setEnable(true);
        cliente02.setIdentifier("kmosquera");
        cliente02.setNit("321");
        cliente02.setRazonSocial("Test SA");
        cliente02.setPassword("123456");

        clienteRepository.saveAll(List.of(cliente01,cliente02));
    }
}
