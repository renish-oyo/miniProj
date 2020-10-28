package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserRequestDTO entityToDto(User user){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserId(user.getUserId());
        userRequestDTO.setEmail(user.getEmail());
        userRequestDTO.setFirstName(user.getFirstName());
        userRequestDTO.setLastName(user.getLastName());
        userRequestDTO.setPhone(user.getPhone());
        return userRequestDTO;
    }

    public User dtoToEntity(UserRequestDTO udto){
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
