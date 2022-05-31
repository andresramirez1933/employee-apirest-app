package com.employeeapirest.app.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUPDTO {

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Username can not be empty")
    private String username;

    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Password or email can not be empty")
    private String password;
}
