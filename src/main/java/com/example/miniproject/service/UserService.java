package com.example.miniproject.service;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    public User saveUser(UserRequestDTO userRequestDTO){
        //checking if email already exists //existsByEmail
        if(!userRepository.existsByEmail(userRequestDTO.getEmail())){
            return userRepository.save(mapper.dtoToEntity(userRequestDTO));
        }
        else {
                return null;
        }
    }



}
