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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
public class FirstController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    //Temporary path to check users saved in User Table
    @GetMapping(path = "/list")
    public List<User> allUsersList(){
        return (List<User>) userRepo.findAll();
    }

    //user create account
    //public ResponseEntity<?> createAccount(@RequestParam(name="first_name") String firstName, @RequestParam(name="last_name") String lastName, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
    //UserDTO userDTO = new UserDTO(firstName,lastName,email,password);

    @PostMapping(path="/sign-up")
    public ResponseEntity<?> createAccount(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getEmail());
        User user = userService.saveUser(userDTO);
        //user returns null when Account already exists.
        if(user==null){
            return new ResponseEntity<>("Account already exists. Please Login",HttpStatus.OK);
        }
        else{
            UserResponse userResponse = new UserResponse(user.getUserId(),user.getFirstName(),user.getLastName(), user.getEmail(), user.getPhone());
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
    }

    //user login
    @GetMapping(path="/login")
    public ResponseEntity<?> loginAccount(@RequestParam(name="email") String email, @RequestParam(name="password") String password){
        //check if email exists or not
        if(userRepo.existsByEmail(email)){
            //email exist
            User user = userRepo.findByEmail(email);
            UserResponse userResponse = new UserResponse(user.getUserId(),user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone());
            //matching passwords
            if(user.getPassword().equals(password)){
                return new ResponseEntity<>(userResponse, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Invalid Password",HttpStatus.NOT_FOUND);
            }
        }
        else {
            //email does't exist
            return new ResponseEntity<>("Account does not exist. Please Sign up.",HttpStatus.NOT_FOUND);
        }
    }
}
