package com.employeeapirest.app.payload;

import lombok.Data;

@Data
public class SignUPDTO {

    private String name;
    private String username;
    private String email;
    private String password;
}