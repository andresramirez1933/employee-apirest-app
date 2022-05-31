package com.employeeapirest.app.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LogInDTO {

    @NotEmpty(message = "Username or email can not be empty")
    private String usernameOrEmail;

    @NotEmpty(message = "Password can not be empty")
    private String password;


}
