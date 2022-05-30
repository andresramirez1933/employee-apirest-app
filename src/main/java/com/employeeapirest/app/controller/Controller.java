package com.employeeapirest.app.controller;


import com.employeeapirest.app.payload.EmployeeDTO;
import com.employeeapirest.app.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class Controller {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> registerEmployee(@RequestBody EmployeeDTO employeeDTO){

        return new ResponseEntity<EmployeeDTO>(serviceEmployee.registerEmployee(employeeDTO),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> ListEmployees(){

        return new ResponseEntity<>(serviceEmployee.listEmployees(),HttpStatus.OK);
    }


}