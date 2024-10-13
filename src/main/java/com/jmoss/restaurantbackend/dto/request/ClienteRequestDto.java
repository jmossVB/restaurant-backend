package com.jmoss.restaurantbackend.dto.request;

import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.entity.Cliente;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClienteRequestDto {


    private String nombre;

    private String apellidos;

    private String correo;

    private String nit;

    private String razonSocial;

    private String password;

    public static Cliente buildtoEntity(ClienteRequestDto clienteRequestDto)
    {
        return Cliente.builder()
                .nombre(clienteRequestDto.getNombre())
                .apellidos(clienteRequestDto.getApellidos())
                .correo(clienteRequestDto.getCorreo())
                .nit(clienteRequestDto.getNit())
                .razonSocial(clienteRequestDto.getRazonSocial())
                .password(clienteRequestDto.getPassword())
                .build();
    }

}
