package com.jmoss.restaurantbackend.service.impl;

import com.jmoss.restaurantbackend.dto.request.ClienteRequestDto;
import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import com.jmoss.restaurantbackend.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteResponseDto> findAllClientes() {
        return List.of();
    }

    @Override
    public ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto) {
        return null;
    }
}
