package com.example.miniproject.controller;

import com.example.miniproject.models.UserResponse;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepo;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class FirstController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;
    //,consumes = MediaType.APPLICATION_JSON_VALUE
    //(name = "first_name",defaultValue = "renish",required = false) @NotNull

    @GetMapping(path = "/list")
    public List<User> allUsersList(){
        return (List<User>) userRepo.findAll();
    }


    @PostMapping(path="/sign-up")
    public UserResponse createAccount(@RequestParam(name="first_name") String firstName, @RequestParam(name="last_name") String lastName, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        UserDTO userDTO = new UserDTO(firstName,lastName,email,password);
        User user = userService.saveUser(userDTO);
        return new UserResponse(user.getUserId(),user.getFirstName(),user.getLastName(), user.getEmail(), user.getPhone());
    }
    
    @GetMapping(path="/login")
    public ResponseEntity<?> loginAccount(@RequestParam(name="email") String email, @RequestParam(name="password") String password){
        if(userRepo.existsByEmail(email)){
            User user = userRepo.findByEmail(email);
            UserResponse userResponse = new UserResponse(user.getUserId(),user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
            if(user.getPassword().equals(password)){
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Invalid Password",HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<>("Account does not exist. Please Sign up.",HttpStatus.NOT_FOUND);
        }
    }
}
