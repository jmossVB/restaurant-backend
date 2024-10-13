package com.jmoss.restaurantbackend.controller;

import com.jmoss.restaurantbackend.dto.request.LoginRequestDto;
import com.jmoss.restaurantbackend.dto.response.LoginResponseDto;
import com.jmoss.restaurantbackend.utils.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        System.out.println("-----------------------------------------------------");
        System.out.println(loginRequestDto);
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(login);
        String jwt = jwtUtil.createToken(loginRequestDto.getUsername());
        return new LoginResponseDto(jwt);
    }


}