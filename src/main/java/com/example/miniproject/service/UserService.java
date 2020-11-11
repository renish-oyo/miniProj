package com.example.miniproject.service;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.models.dto.EmployeeDTO;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.EmployeeRepo;
import com.example.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Mapper mapper;

    // SAVE USER
    public User saveUser(UserDTO userDTO){
        //checking if email already exists //existsByEmail
        if(!userRepository.existsByEmail(userDTO.getEmail())){
            return userRepository.save(mapper.dtoToEntity(userDTO));
        }
        else {
                return null;
        }
    }



    // UPDATE USER
    public User updateUser(UserDTO userDTO){
        return userRepository.save(mapper.dtoToEntity(userDTO));
    }


}