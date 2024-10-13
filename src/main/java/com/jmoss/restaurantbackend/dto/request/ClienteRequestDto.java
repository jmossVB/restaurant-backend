package com.jmoss.restaurantbackend.dto.request;

import com.jmoss.restaurantbackend.dto.response.ClienteResponseDto;
import com.jmoss.restaurantbackend.entity.Cliente;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Data
@Builder
public class ClienteRequestDto {

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Size(min = 3, message = "El nombre Debe tener una longitud mayor a 3 caracteres")
    private String nombre;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Size(min = 5, max = 100)
    private String apellidos;

    @Email
    @NotNull
    @NotEmpty
    private String correo;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    private String nit;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    private String razonSocial;

    @NotNull(message = "No se permiten valores nulos")
    @NotEmpty(message = "No se permiten valores nulos")
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{6,20})", message = "El password debe tener minimo 8 caracteres, mayusculas minusculas y al menos un numero y un caracter especial.")
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
