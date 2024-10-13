package com.jmoss.restaurantbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Cliente {

    @Id
    @Column(name = "cli_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name ="cli_identifier", unique = true)
    private String identifier;

    @Column(name ="cli_nombre")
    private String nombre;

    @Column(nullable = false, length = 100, name = "cli_apellidos")
    private String apellidos;

    private String correo;

    private String razonSocial;

    @Column(nullable = false, unique = true)
    private String nit;

    private String password;


}
