package com.example.miniproject.service;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Mapper mapper;

    public User saveUser(UserRequestDTO userRequestDTO){
        //checking if email already exists //existsByEmail
        if(!userRepo.existsByEmail(userRequestDTO.getEmail())){
            return userRepo.save(mapper.dtoToEntity(userRequestDTO));
        }
        else {
                return null;
        }
    }

}
