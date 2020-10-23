package com.example.miniproject.controller;

import com.example.miniproject.mapper.Converter;
import com.example.miniproject.models.SignUpResponse;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/user")
public class FirstController {
    @Autowired
    private UserService userService;

    @Autowired
    private Converter convert;
    //,consumes = MediaType.APPLICATION_JSON_VALUE
    //(name = "first_name",defaultValue = "renish",required = false) @NotNull

    @PostMapping(value="/sign-up")
    public  SignUpResponse createAccount(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password){
        UserDTO udto = new UserDTO(firstName,lastName,email,password);
        User u = userService.saveUser(udto);
        if(u==null){
            return new SignUpResponse();
        }
        else{
            return new SignUpResponse(u.getUser_id(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPhone());
        }
    }
}
