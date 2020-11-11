package com.example.miniproject.controller;
import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.SalaryDTO;
import com.example.miniproject.models.entity.Company;
import com.example.miniproject.models.entity.Salary;
import com.example.miniproject.repository.SalaryRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

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
    @PostMapping(path = "/add")
    public SalaryDTO addNewSalary(@RequestBody SalaryDTO salaryDTO){
        ModelMapper modelMapper = new ModelMapper();
        Salary salary =  salaryRepo.save(modelMapper.map(salaryDTO, Salary.class));
        return modelMapper.map(salary,SalaryDTO.class);
    }

    // FETCH ALL SALARIES
    @GetMapping("/all")
    public List<SalaryDTO> salaryList(){
        List<Salary> salaryList = (List<Salary>) salaryRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        Type salaryDtoList = new TypeToken<List<SalaryDTO>>(){}.getType();
        return modelMapper.map(salaryList,salaryDtoList);
    }


    // UPDATE SALARY INFORMATION
    @PutMapping("/update")
    public SalaryDTO updateSalaryInfo(@RequestBody SalaryDTO salaryDTO){
        ModelMapper modelMapper = new ModelMapper();
        Salary salary = salaryRepo.save(modelMapper.map(salaryDTO,Salary.class));
        return modelMapper.map(salary,SalaryDTO.class);
    }

    // DELETE SALARY INFORMATION
    @DeleteMapping("/delete")
    public String deleteSalary(@RequestParam(name = "salary_id") int salaryId){
        if(salaryRepo.existsById(salaryId)){
            Optional<Salary> salary = salaryRepo.findById(salaryId);
            if(salary.get().isActive()){
                salaryRepo.setSalaryInactive(salaryId);
                return "Salary ("+salaryId+") is now inactive.";
            }
            else
                return "Salary ("+salaryId+") is already inactive.";
        }
        else {
            return "Salary with Id "+salaryId+" does not exist.";
        }
    }

}
