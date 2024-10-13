package com.jmoss.restaurantbackend.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse <T>
{
    private HttpStatus statusCode;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data, String message)
    {
        return CommonResponse.<T>builder()
                .statusCode(HttpStatus.ACCEPTED)
                .message(message)
                .data(data)
                .build();
    }
}
