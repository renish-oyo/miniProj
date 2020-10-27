package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDTO entityToDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }

    public User dtoToEntity(UserDTO udto){
        User user = new User();
        user.setUserId(udto.getUserId());
        user.setEmail(udto.getEmail());
        user.setFirstName(udto.getFirstName());
        user.setLastName(udto.getLastName());
        user.setPhone(udto.getPhone());
        user.setPassword(udto.getPassword());
        return user;
    }

}
