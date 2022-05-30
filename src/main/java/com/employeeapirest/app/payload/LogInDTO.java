package com.employeeapirest.app.payload;

import lombok.Data;

@Data
public class LogInDTO {

    private String usernameOrEmail;
    private String password;


}
