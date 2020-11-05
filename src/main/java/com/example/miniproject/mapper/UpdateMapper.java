package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateMapper {

    @Autowired
    private UserRepository userRepository;

    public UserDTO map(UserDTO userDTO){
        System.out.println(userDTO);
        Optional<User> user = userRepository.findById(userDTO.getUserId());

        //null fields are replaced with it's original value
        userDTO.setPassword(user.get().getPassword());
        if(userDTO.getFirstName()==null){
            userDTO.setFirstName(user.get().getFirstName());
        }
        if(userDTO.getLastName()==null) {
            userDTO.setLastName(user.get().getLastName());
        }
        if(userDTO.getAadharNumber()==null) {
            userDTO.setAadharNumber(user.get().getAadharNumber());
        }
        if(userDTO.getEmail()==null) {
            userDTO.setEmail(user.get().getEmail());
        }
        if(userDTO.getPanNumber()==null) {
            userDTO.setPanNumber(user.get().getPanNumber());
        }
        if(userDTO.getAddress()==null) {
            userDTO.setAddress(user.get().getAddress());
        }
        if(userDTO.getBankAccountNumber()==null) {
            userDTO.setBankAccountNumber(user.get().getBankAccountNumber());
        }
        if(userDTO.getBankName()==null) {
            userDTO.setBankName(user.get().getBankName());
        }
        if(userDTO.getBanKIfscCode()==null) {
            userDTO.setBanKIfscCode(user.get().getBanKIfscCode());
        }
        if(userDTO.getGender()==null) {
            userDTO.setGender(user.get().getGender());
        }
        if(userDTO.getPhone()==null) {
            userDTO.setPhone(user.get().getPhone());
        }
        if(userDTO.getRole()==null){
            userDTO.setRole(user.get().getRole());
        }
        if(userDTO.getImage()==null){
            userDTO.setImage(user.get().getImage());
        }
        return userDTO;
    }
}
