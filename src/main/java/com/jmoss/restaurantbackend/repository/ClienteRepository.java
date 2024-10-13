package com.jmoss.restaurantbackend.repository;

import com.jmoss.restaurantbackend.entity.Cliente;
import org.springframework.data.repository.ListCrudRepository;


public interface ClienteRepository extends ListCrudRepository<Cliente, Integer> {

}
