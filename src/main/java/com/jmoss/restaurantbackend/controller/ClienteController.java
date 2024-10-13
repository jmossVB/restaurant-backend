package com.jmoss.restaurantbackend.controller;

import com.jmoss.restaurantbackend.dto.request.ClienteRequestDto;
import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import com.jmoss.restaurantbackend.service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping()
    public List<ClienteResponseDto> findAllClientes() {
        return clienteService.findAllClientes();
    };

    @PostMapping()
    public ClienteResponseDto createClientes( @RequestBody @Valid ClienteRequestDto clienteRequestDto ) {
        return clienteService.createCliente(clienteRequestDto);
    };




}
