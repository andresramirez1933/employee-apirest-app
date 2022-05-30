package com.employeeapirest.app.payload;

import lombok.Data;

@Data
public class JwtAuthResponseDTO {

    private String accessToken;
    private String typeToken;

    public JwtAuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
        typeToken = "Bearer";
    }
}
