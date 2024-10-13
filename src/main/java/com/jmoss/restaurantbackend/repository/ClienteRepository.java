package com.jmoss.restaurantbackend.repository;

import com.jmoss.restaurantbackend.entity.Cliente;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;


public interface ClienteRepository extends ListCrudRepository<Cliente, Integer> {

    Optional<Cliente> findByCorreo(String correo);

}
