package com.example.miniproject.service;

import com.example.miniproject.mapper.Converter;
import com.example.miniproject.exception.AlreadyExistsException;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo urepo;

    @Autowired
    private Converter convert;

    public User saveUser(UserDTO udto){
        //checking if email already exists //existsByEmail
        if(urepo.findByEmail(udto.getEmail())==null ){
            return urepo.save(convert.dtoToEntity(udto));
        }
        else {
            throw new AlreadyExistsException("abc");
        }
    }
}
