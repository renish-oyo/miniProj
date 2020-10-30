package com.example.miniproject.mapper;
import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.dto.UserResponseDTO;
import com.example.miniproject.models.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public UserResponseDTO entityToDto(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setActive(user.isActive());
        userResponseDTO.setAadharNumber(user.getAadharNumber());
        userResponseDTO.setPanNumber(user.getPanNumber());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setBankName(user.getBankName());
        userResponseDTO.setBankAccountNumber(user.getBankAccountNumber());
        userResponseDTO.setBanKIfscCode(user.getBanKIfscCode());
        userResponseDTO.setGender(user.getGender());
        return userResponseDTO;
    }

    public User dtoToEntity(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setUserId(userRequestDTO.getUserId());
        user.setEmail(userRequestDTO.getEmail());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());
        user.setActive(userRequestDTO.isActive());
        user.setAddress(userRequestDTO.getAddress());
        user.setAadharNumber(userRequestDTO.getAadharNumber());
        user.setPanNumber(userRequestDTO.getPanNumber());
        user.setBankName(userRequestDTO.getBankName());
        user.setBankAccountNumber(userRequestDTO.getBankAccountNumber());
        user.setBanKIfscCode(userRequestDTO.getBanKIfscCode());
        user.setGender(userRequestDTO.getGender());
        return user;
    }

    // map List of Entity to List of DTO
    public List<UserResponseDTO> entityToDtoList(List<User> userList){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : userList) {
            userResponseDTOList.add(entityToDto(user));
        }
        return userResponseDTOList;
    }

    //map List of DTO to List of Entity
    public List<User> dtoToEntityList(List<UserRequestDTO> userRequestDTOList){
        List<User> userList = new ArrayList<>();
        for(UserRequestDTO userRequestDTO : userRequestDTOList){
            userList.add(dtoToEntity(userRequestDTO));
        }
        return userList;
    }
}
