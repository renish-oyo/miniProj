package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.DepartmentDTO;
import com.example.miniproject.models.entity.Department;
import com.example.miniproject.repository.DepartmentRepo;
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
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentRepo departmentRepo;

    //Constructor injection is better than field injection
    @Autowired
    public DepartmentController(UserService userService, DepartmentRepo departmentRepo, Mapper mapper, UpdateMapper updateMapper) {
        this.departmentRepo=departmentRepo;
    }

    // ADD NEW DEPARTMENT-- API
    @PostMapping(path = "/add")
    public Department addNewDepartment(@RequestBody DepartmentDTO departmentDTO){
        ModelMapper modelMapper = new ModelMapper();
        return departmentRepo.save(modelMapper.map(departmentDTO, Department.class));
    }

    //GET LIST OF ALL DEPARTMENTS
    @GetMapping(path = "/all")
    public List<DepartmentDTO> allDepartments(){
        List<Department> departmentList = (List<Department>) departmentRepo.findAll();
        // MAPPING Company List To CompanyDTO List
        ModelMapper modelMapper = new ModelMapper();
        Type departmentDtoList = new TypeToken<List<DepartmentDTO>>(){}.getType();
        final List<DepartmentDTO> map = modelMapper.map(departmentList, departmentDtoList);
        return map;
    }

    //UPDATE DEPARTMENT
    @PutMapping(path = "/update")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        ModelMapper modelMapper = new ModelMapper();
        Department department = departmentRepo.save(modelMapper.map(departmentDTO,Department.class));
        return modelMapper.map(department,DepartmentDTO.class);
    }

    //DELETE DEPARTMENT
    @DeleteMapping(path = "/delete")
    public String deleteDepartment(@RequestParam(name = "dept_id") int departmentId) {
        if (departmentRepo.existsById(departmentId)) {
            Optional<Department> department = departmentRepo.findById(departmentId);
            if (department.get().isActive()) {
                departmentRepo.setDepartmentInactive(departmentId);
                return "Department ("+departmentId+") is now inactive.";
            } else
                return "Department ("+departmentId+") is already inactive.";
        } else {
            return "Department with Id " + departmentId + " does not exist.";
        }
    }
}
