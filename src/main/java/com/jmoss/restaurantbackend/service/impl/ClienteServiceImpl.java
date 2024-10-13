package com.jmoss.restaurantbackend.service.impl;

import com.jmoss.restaurantbackend.dto.request.ClienteRequestDto;
import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.exception.EmptyListException;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import com.jmoss.restaurantbackend.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteResponseDto> findAllClientes() {

        List<Cliente> clientes;
        try
        {
            clientes = clienteRepository.findAll();
            if (clientes.size()==0)
            {
                throw new EmptyListException("No se encuentran clientes");
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Error al realizar la petición de clientes");
        }

        return clientes.stream().map(ClienteResponseDto::buildFromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public ClienteResponseDto createCliente(ClienteRequestDto clienteRequestDto) {
        try
        {
            Cliente cliente = clienteRepository.save(ClienteRequestDto.buildtoEntity(clienteRequestDto));
            return ClienteResponseDto.buildFromEntity(cliente);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
