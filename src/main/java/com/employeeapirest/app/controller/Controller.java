package com.employeeapirest.app.controller;


import com.employeeapirest.app.payload.EmployeeDTO;
import com.employeeapirest.app.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class Controller {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<EmployeeDTO> registerEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){

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

    // it gets employees by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByRole(@PathVariable("role") String role){

        return new ResponseEntity<>(serviceEmployee.findByRole(role),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employeeDTO){

        return new ResponseEntity<EmployeeDTO>(serviceEmployee.updateEmployee(employeeId, employeeDTO),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        serviceEmployee.deleteEmployee(employeeId);

        return new ResponseEntity<String>("Employee deleted",HttpStatus.OK);
    }

    //added a new comment


}
