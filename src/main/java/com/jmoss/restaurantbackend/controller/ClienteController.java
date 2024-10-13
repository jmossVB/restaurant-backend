package com.jmoss.restaurantbackend.controller;

import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    };

    @PostMapping()
    public Cliente createClientes( @RequestBody Cliente cliente ) {
        return clienteRepository.save(cliente);
    };




}
