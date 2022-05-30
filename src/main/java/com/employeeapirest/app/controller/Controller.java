package com.employeeapirest.app.controller;


import com.employeeapirest.app.payload.EmployeeDTO;
import com.employeeapirest.app.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class Controller {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<EmployeeDTO> registerEmployee(@RequestBody EmployeeDTO employeeDTO){

        return new ResponseEntity<EmployeeDTO>(serviceEmployee.registerEmployee(employeeDTO),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> ListEmployees(){

        return new ResponseEntity<>(serviceEmployee.listEmployees(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){

        return new ResponseEntity<EmployeeDTO>(serviceEmployee.getEmployeeById(employeeId),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employeeDTO){

        return new ResponseEntity<EmployeeDTO>(serviceEmployee.updateEmployee(employeeId, employeeDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        serviceEmployee.deleteEmployee(employeeId);

        return new ResponseEntity<String>("Employee deleted",HttpStatus.OK);
    }


}
