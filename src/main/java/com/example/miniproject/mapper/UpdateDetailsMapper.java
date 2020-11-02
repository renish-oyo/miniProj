package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDetailsMapper {

    @Autowired
    UserRepository userRepository;


    public UserRequestDTO updateDetailsMapper(UserRequestDTO userRequestDTO){
        System.out.println(userRequestDTO);


        return userRequestDTO;
    }
}
