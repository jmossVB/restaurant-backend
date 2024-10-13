package com.jmoss.restaurantbackend.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private HttpStatus statusCode;
    private T message;
    private String timestamp;
    private String path;
}
