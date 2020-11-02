package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateMapper {

    @Autowired
    private UserRepository userRepository;

    public UserRequestDTO map(UserRequestDTO userRequestDTO){
        System.out.println(userRequestDTO);
        Optional<User> user = userRepository.findById(userRequestDTO.getUserId());

        //null fields are replaced with it's original value
        userRequestDTO.setPassword(user.get().getPassword());
        if(userRequestDTO.getFirstName()==null){
            userRequestDTO.setFirstName(user.get().getFirstName());
        }
        if(userRequestDTO.getLastName()==null) {
            userRequestDTO.setLastName(user.get().getLastName());
        }
        if(userRequestDTO.getAadharNumber()==null) {
            userRequestDTO.setAadharNumber(user.get().getAadharNumber());
        }
        if(userRequestDTO.getEmail()==null) {
            userRequestDTO.setEmail(user.get().getEmail());
        }
        if(userRequestDTO.getPanNumber()==null) {
            userRequestDTO.setPanNumber(user.get().getPanNumber());
        }
        if(userRequestDTO.getAddress()==null) {
            userRequestDTO.setAddress(user.get().getAddress());
        }
        if(userRequestDTO.getBankAccountNumber()==null) {
            userRequestDTO.setBankAccountNumber(user.get().getBankAccountNumber());
        }
        if(userRequestDTO.getBankName()==null) {
            userRequestDTO.setBankName(user.get().getBankName());
        }
        if(userRequestDTO.getBanKIfscCode()==null) {
            userRequestDTO.setBanKIfscCode(user.get().getBanKIfscCode());
        }
        if(userRequestDTO.getGender()==null) {
            userRequestDTO.setGender(user.get().getGender());
        }
        if(userRequestDTO.getPhone()==null) {
            userRequestDTO.setPhone(user.get().getPhone());
        }
        if(userRequestDTO.getRole()==null){
            userRequestDTO.setRole(user.get().getRole());
        }
        if(userRequestDTO.getImage()==null){
            userRequestDTO.setImage(user.get().getImage());
        }
        return userRequestDTO;
    }
}
