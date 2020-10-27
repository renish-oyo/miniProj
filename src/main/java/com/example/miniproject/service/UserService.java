package com.example.miniproject.service;

import com.example.miniproject.exception.AlreadyExistsException;
import com.example.miniproject.exception.InvalidPasswordException;
import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Mapper mapper;

    public User saveUser(UserDTO userDTO){
        //checking if email already exists //existsByEmail
        if(!userRepo.existsByEmail(userDTO.getEmail())){
            return userRepo.save(mapper.dtoToEntity(userDTO));
        }
        else {
                return null;
        }
    }

}
