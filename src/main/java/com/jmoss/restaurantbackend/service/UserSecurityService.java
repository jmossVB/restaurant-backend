package com.jmoss.restaurantbackend.service;

import com.jmoss.restaurantbackend.entity.Cliente;
import com.jmoss.restaurantbackend.repository.ClienteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final ClienteRepository clientRepository;


    public UserSecurityService(ClienteRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clientRepository.findByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
        System.out.println(cliente);
        return User.builder()
                .username(cliente.getCorreo())
                .password(cliente.getPassword())
                .build();
    }

}
