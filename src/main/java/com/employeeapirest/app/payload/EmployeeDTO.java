package com.employeeapirest.app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    private Long id;

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Role can not be empty")
    @Size(min = 4, max = 15, message = "The size must be between 4 and 15 letters")
    private String role;
}
