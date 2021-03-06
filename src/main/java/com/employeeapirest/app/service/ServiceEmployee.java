package com.employeeapirest.app.service;

import com.employeeapirest.app.entity.Employee;
import com.employeeapirest.app.payload.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface ServiceEmployee {

    List<EmployeeDTO> listEmployees();

    EmployeeDTO registerEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findByRole(String role);

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO updateEmployee(Long idEmployee, EmployeeDTO employeeDTO);

    void deleteEmployee(Long idEmployee);


}
