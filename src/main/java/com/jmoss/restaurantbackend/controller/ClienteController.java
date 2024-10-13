package com.jmoss.restaurantbackend.controller;

import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("clientes")
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    };

    @PostMapping("clientes")
    public Cliente createClientes( @RequestBody Cliente cliente ) {
        return clienteRepository.save(cliente);
    };




}
