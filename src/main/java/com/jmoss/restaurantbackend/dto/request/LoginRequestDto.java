package com.jmoss.restaurantbackend.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class LoginRequestDto {

    private String username;

    private String password;
}