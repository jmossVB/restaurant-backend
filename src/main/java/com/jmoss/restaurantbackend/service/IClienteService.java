package com.jmoss.restaurantbackend.service;

import com.jmoss.restaurantbackend.dto.request.ClienteRequestDto;
import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.repository.ClienteRepository;

import java.util.List;

public interface IClienteService
{
    public List<ClienteResponseDto> findAllClientes();

    public ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto);



}
