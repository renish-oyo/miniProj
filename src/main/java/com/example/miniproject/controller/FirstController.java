package com.example.miniproject.controller;

import com.example.miniproject.models.dto.UserResponseDTO;
import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
public class FirstController {

    private final UserService userService;
    private final UserRepository userRepository;

    //Constructor injection is better than field injection
    @Autowired
    public FirstController(UserService userService,UserRepository userRepository) {
        this.userService=userService;
        this.userRepository=userRepository;
    }

    //Temporary path to check users saved in User Table
    @GetMapping(path = "/list")
    public List<User> allUsersList(){
        return (List<User>) userRepository.findAll();
    }

    //user create account
    @PostMapping(path="/sign-up")
    public ResponseEntity<?> createAccount(@RequestBody UserRequestDTO userRequestDTO){
        User user = userService.saveUser(userRequestDTO);
        //user returns null when Account already exists.
        if(user==null){
            return new ResponseEntity<>("Account already exists. Please Login",HttpStatus.OK);
        }
        else{
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(),user.getFirstName(),user.getLastName(), user.getEmail(), user.getPhone());
            return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
        }
    }

    //user login
    @GetMapping(path="/login")
    public ResponseEntity<?> loginAccount(@RequestBody UserRequestDTO userRequestDTO){
        //check if email exists or not
        if(userRepository.existsByEmail(userRequestDTO.getEmail())){
            User user = userRepository.findByEmail(userRequestDTO.getEmail());
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(),user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
            //matching passwords
            if(user.getPassword().equals(userRequestDTO.getPassword())){
                return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Invalid Password",HttpStatus.NOT_FOUND);
            }
        }
        else {
            //email doesn't exist
            return new ResponseEntity<>("Account does not exist. Please Sign up.",HttpStatus.NOT_FOUND);
        }
    }
}
