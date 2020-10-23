package com.example.miniproject.converter;

import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public UserDTO entityToDto(User u){
        System.out.println("6");
        UserDTO udto = new UserDTO();
        udto.setEmail(u.getEmail());
        udto.setFirstName(u.getFirstName());
        udto.setUser_id(u.getUser_id());
        udto.setLastName(u.getLastName());
        udto.setPassword(u.getPassword());
        udto.setPhone(u.getPhone());
        System.out.println("7");
        return udto;
    }

    public User dtoToEntity(UserDTO udto){
        User u = new User();
        u.setUser_id(udto.getUser_id());
        u.setEmail(udto.getEmail());
        u.setFirstName(udto.getFirstName());
        u.setLastName(udto.getLastName());
        u.setPhone(udto.getPhone());
        u.setPassword(udto.getPassword());
        return u;
    }

}
