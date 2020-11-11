package com.example.miniproject.service;

import com.example.miniproject.models.dto.EmployeeDTO;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    //SAVE EMPLOYEE
    public Employee saveEmployee(EmployeeDTO employeeDTO){
        //checking if email already exists //existsByEmail
        if(!employeeRepo.existsByEmail(employeeDTO.getEmail())){
            ModelMapper modelMapper = new ModelMapper();
            return employeeRepo.save(modelMapper.map(employeeDTO,Employee.class));
        }
        else {
            return null;
        }
    }


    // UPDATE EMPLOYEE
    public Employee updateEmployee(EmployeeDTO employeeDTO){
        ModelMapper modelMapper = new ModelMapper();
        return employeeRepo.save(modelMapper.map(employeeDTO,Employee.class));
    }
}
