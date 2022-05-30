package com.employeeapirest.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class EmployeeApiException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;
}
