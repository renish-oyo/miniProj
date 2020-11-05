package com.example.miniproject.controller;
import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.SalaryDTO;
import com.example.miniproject.models.entity.Salary;
import com.example.miniproject.repository.SalaryRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/salary")
public class SalaryController {
    private final UserService userService;
    private final SalaryRepo salaryRepo;
    private final Mapper mapper;
    private final UpdateMapper updateMapper;

    //Constructor injection is better than field injection
    @Autowired
    public SalaryController(UserService userService, SalaryRepo salaryRepo, Mapper mapper, UpdateMapper updateMapper) {
        this.userService = userService;
        this.salaryRepo=salaryRepo;
        this.mapper = mapper;
        this.updateMapper=updateMapper;
    }

    // ADD NEW SALARY API
    @PostMapping(path = "/add-salary")
    public Salary addNewSalary(@RequestBody SalaryDTO salaryDTO){
        ModelMapper modelMapper = new ModelMapper();
        return salaryRepo.save(modelMapper.map(salaryDTO, Salary.class));
    }
}
