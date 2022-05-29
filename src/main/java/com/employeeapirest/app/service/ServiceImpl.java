package com.employeeapirest.app.service;

import com.employeeapirest.app.entity.Employee;
import com.employeeapirest.app.payload.EmployeeDTO;
import com.employeeapirest.app.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements ServiceEmployee {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> listEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());


    }

    @Override
    public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO) {

        Employee employee = mapToEntity(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToDTO(savedEmployee);

    }

    private Employee mapToEntity(EmployeeDTO employeeDTO){

        return modelMapper.map(employeeDTO, Employee.class);

    }

    private EmployeeDTO mapToDTO(Employee employee){

        return modelMapper.map(employee, EmployeeDTO.class);

    }
}
