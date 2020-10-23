package com.example.miniproject.service;

import com.example.miniproject.converter.Converter;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo urepo;

    @Autowired
    Converter convert;

    public User save(UserDTO udto){
        User u = new User();
        u = convert.dtoToEntity(udto);
        return urepo.save(u);
    }
}
