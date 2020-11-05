package com.example.miniproject.mapper;
import com.example.miniproject.models.dto.*;
import com.example.miniproject.models.dto.ResponseDTO;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.models.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public ResponseDTO entityToDto(User user){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setPhone(user.getPhone());
        responseDTO.setActive(user.isActive());
        responseDTO.setAadharNumber(user.getAadharNumber());
        responseDTO.setPanNumber(user.getPanNumber());
        responseDTO.setCity(user.getCity());
        responseDTO.setStreet(user.getStreet());
        responseDTO.setState(user.getState());
        responseDTO.setCountry(user.getCountry());
        responseDTO.setBankName(user.getBankName());
        responseDTO.setBankAccountNumber(user.getBankAccountNumber());
        responseDTO.setBanKIfscCode(user.getBanKIfscCode());
        responseDTO.setGender(user.getGender());
        responseDTO.setImage(user.getImage());
        responseDTO.setDesignation(user.getDesignation());
        return responseDTO;
    }

    public User dtoToEntity(UserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setActive(userDTO.isActive());
        user.setStreet(userDTO.getStreet());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setCountry(userDTO.getCountry());
        user.setAadharNumber(userDTO.getAadharNumber());
        user.setPanNumber(userDTO.getPanNumber());
        user.setBankName(userDTO.getBankName());
        user.setBankAccountNumber(userDTO.getBankAccountNumber());
        user.setBanKIfscCode(userDTO.getBanKIfscCode());
        user.setGender(userDTO.getGender());
        user.setImage(userDTO.getImage());
        user.setDesignation(userDTO.getDesignation());
        return user;
    }

    public Employee employeeDtoToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPhone(employeeDTO.getPhone());
        employee.setPassword(employeeDTO.getPassword());
        employee.setActive(employeeDTO.isActive());
        employee.setStreet(employeeDTO.getStreet());
        employee.setCity(employeeDTO.getCity());
        employee.setState(employeeDTO.getState());
        employee.setCountry(employeeDTO.getCountry());
        employee.setAadharNumber(employeeDTO.getAadharNumber());
        employee.setPanNumber(employeeDTO.getPanNumber());
        employee.setBankName(employeeDTO.getBankName());
        employee.setBankAccountNumber(employeeDTO.getBankAccountNumber());
        employee.setBanKIfscCode(employeeDTO.getBanKIfscCode());
        employee.setGender(employeeDTO.getGender());
        employee.setImage(employeeDTO.getImage());
        employee.setDesignation(employeeDTO.getDesignation());
        return employee;
    }


    // map List of Entity to List of DTO
    public List<ResponseDTO> entityToDtoList(List<User> userList){
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        for (User user : userList) {
            responseDTOList.add(entityToDto(user));
        }
        return responseDTOList;
    }

    //map List of DTO to List of Entity
    public List<User> dtoToEntityList(List<UserDTO> userDTOList){
        List<User> userList = new ArrayList<>();
        for (UserDTO userDto : userDTOList)
        {
            userList.add(dtoToEntity(userDto));
        }
        return userList;
    }

    public List<Employee> employeeDtoToEmployeeList(List<EmployeeDTO> employeeDTOList){
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO employeeDTO: employeeDTOList)
        {
            employeeList.add(employeeDtoToEmployee(employeeDTO));
        }
        return employeeList;
    }
}
