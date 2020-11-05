package com.example.miniproject.controller;
import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.EmployeeDTO;
import com.example.miniproject.models.dto.ResponseDTO;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.repository.EmployeeRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final UserService userService;
    private final EmployeeRepo employeeRepo;
    private final Mapper mapper;
    private final UpdateMapper updateMapper;

    //Constructor injection is better than field injection
    @Autowired
    public EmployeeController(UserService userService, EmployeeRepo employeeRepo, Mapper mapper,UpdateMapper updateMapper) {
        this.userService = userService;
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
        this.updateMapper=updateMapper;
    }

    //user create account
    @PostMapping(path = "/sign-up")
    public ResponseDTO createAccount(@Valid @RequestBody EmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = employeeRepo.save(modelMapper.map(employeeDTO,Employee.class));
        ResponseDTO responseDTO;
        responseDTO = modelMapper.map(employee,ResponseDTO.class);
        return responseDTO;
    }

    @GetMapping(path = "all")
    public List<ResponseDTO> fetchAllEmployees(){
        List<Employee> employeeList = (List<Employee>) employeeRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ResponseDTO>>(){}.getType();
        List<ResponseDTO> responseDTOList = modelMapper.map(employeeList,listType);
        return responseDTOList;
    }

}