package com.jmoss.restaurantbackend.dto.response;

import com.jmoss.restaurantbackend.entity.Cliente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponseDto {

    private Integer id;

    private String identifier;

    private String nombre;

    private String apellidos;

    private String correo;

    private boolean enable;

    private String nit;

    public static ClienteResponseDto buildFromEntity(Cliente cliente)
    {
        return ClienteResponseDto.builder()
                .id(cliente.getId())
                .identifier(cliente.getIdentifier())
                .nombre(cliente.getNombre())
                .apellidos(cliente.getApellidos())
                .correo(cliente.getCorreo())
                .enable(cliente.isEnable())
                .nit(cliente.getNit())
                .build();
    }

    public static Cliente buildtoEntity(ClienteResponseDto clienteResponseDto)
    {
        return Cliente.builder()
                .id(clienteResponseDto.getId())
                .identifier(clienteResponseDto.getIdentifier())
                .nombre(clienteResponseDto.getNombre())
                .apellidos(clienteResponseDto.getApellidos())
                .correo(clienteResponseDto.getCorreo())
                .enable(clienteResponseDto.isEnable())
                .nit(clienteResponseDto.getNit())
                .build();
    }

}
