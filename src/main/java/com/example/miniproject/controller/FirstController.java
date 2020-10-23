package com.example.miniproject.controller;

import com.example.miniproject.converter.Converter;
import com.example.miniproject.models.SignUpResponse;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @Autowired
    UserService uservice;

    @Autowired
    Converter convert;

    @PostMapping("/signup")
    public  SignUpResponse signup(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String password){
        UserDTO udto = new UserDTO(firstName,lastName,email,password);
        User u = new User();
        u = uservice.save(udto);
        SignUpResponse response = new SignUpResponse(u.getUser_id(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPhone());
        return response;
    }
}
