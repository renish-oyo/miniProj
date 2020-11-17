package com.example.miniproject.controller;

import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.EmployeeDTO;
import com.example.miniproject.models.dto.ResponseDTO;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.repository.EmployeeRepo;
import com.example.miniproject.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;
    private final UpdateMapper updateMapper;
    private final EmployeeService employeeService;
    //Constructor injection is better than field injection
    @Autowired
    public EmployeeController(EmployeeService employeeService,EmployeeRepo employeeRepo, UpdateMapper updateMapper) {
        this.employeeService=employeeService;
        this.employeeRepo = employeeRepo;
        this.updateMapper=updateMapper;
    }

    // CREATE NEW EMPLOYEE
    @PostMapping(path = "/sign-up")
    public ResponseDTO createAccount(@Valid @RequestBody EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = employeeRepo.save(modelMapper.map(employeeDTO,Employee.class));
        ResponseDTO responseDTO;
        responseDTO = modelMapper.map(employee,ResponseDTO.class);
        return responseDTO;
    }

    // FETCH ALL EMPLOYEES
    @GetMapping(path = "/all")
    public List<ResponseDTO> fetchAllEmployees(){
        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ResponseDTO>>(){}.getType();
        List<ResponseDTO> responseDTOList = modelMapper.map(employeeList,listType);
        return responseDTOList;
    }

    // UPDATE EMPLOYEE
    @PutMapping(path = "/update")
    public ResponseDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        employeeDTO =updateMapper.employeeMap(employeeDTO);
        System.out.println(employeeDTO);
        Employee employee = employeeService.updateEmployee(employeeDTO);
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(employee,ResponseDTO.class);
    }

    @DeleteMapping(path = "/delete")
    public String deleteEmployee(@RequestParam(name = "emp_id") int employeeId) {
        if (employeeRepo.existsById(employeeId)) {
            Optional<Employee> employee = employeeRepo.findById(employeeId);
            if (employee.get().isActive()) {
                employeeRepo.setEmployeeInactive(employeeId);
                return "Employee ("+employeeId+") is now inactive.";
            } else
                return "Employee ("+employeeId+") is already inactive.";
        } else {
            return "Employee with Id " + employeeId + " does not exist.";
        }
    }
}