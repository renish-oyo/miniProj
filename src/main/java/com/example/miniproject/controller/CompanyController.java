package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.CompanyDTO;
import com.example.miniproject.models.entity.Company;
import com.example.miniproject.repository.CompanyRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/company")
public class CompanyController {
    private final UserService userService;
    private final CompanyRepo companyRepo;
    private final Mapper mapper;
    private final UpdateMapper updateMapper;

    //Constructor injection is better than field injection
    @Autowired
    public CompanyController(UserService userService, CompanyRepo companyRepo, Mapper mapper, UpdateMapper updateMapper) {
        this.userService = userService;
        this.companyRepo=companyRepo;
        this.mapper = mapper;
        this.updateMapper=updateMapper;
    }

    // ADD NEW COMPANY API
    @PostMapping(path = "/add-company")
    public Company addNewCompany(@RequestBody CompanyDTO companyDTO){
        ModelMapper modelMapper = new ModelMapper();
        return companyRepo.save(modelMapper.map(companyDTO,Company.class));
    }
}
