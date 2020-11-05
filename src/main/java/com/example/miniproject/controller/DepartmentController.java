package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.CompanyDTO;
import com.example.miniproject.models.dto.DepartmentDTO;
import com.example.miniproject.models.entity.Company;
import com.example.miniproject.models.entity.Department;
import com.example.miniproject.repository.DepartmentRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/department")
public class DepartmentController {
    private final UserService userService;
    private final DepartmentRepo departmentRepo;
    private final Mapper mapper;
    private final UpdateMapper updateMapper;

    //Constructor injection is better than field injection
    @Autowired
    public DepartmentController(UserService userService, DepartmentRepo departmentRepo, Mapper mapper, UpdateMapper updateMapper) {
        this.userService = userService;
        this.departmentRepo=departmentRepo;
        this.mapper = mapper;
        this.updateMapper=updateMapper;
    }

    // ADD NEW DEPARTMENT-- API
    @PostMapping(path = "/add-department")
    public Department addNewDepartment(@RequestBody DepartmentDTO departmentDTO){
        ModelMapper modelMapper = new ModelMapper();
        return departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
    }
}
