package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.models.dto.UserRequestDTO;
import com.example.miniproject.models.dto.UserResponseDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final Mapper mapper;

    //Constructor injection is better than field injection
    @Autowired
    public UserController(UserService userService, UserRepository userRepository, Mapper mapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    //Temporary path to check users saved in User Table
    @GetMapping(path = "/list")
    public List<User> allUsersList() {
        return (List<User>) userRepository.findAll();
    }

    //user create account
    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> createAccount(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.saveUser(userRequestDTO);
        //user returns null when Account already exists.
        if (user == null) {
            return new ResponseEntity<>("Account already exists. Please Login", HttpStatus.OK);
        } else {
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(), user.getPhone(), user.getAadharNumber(), user.getPanNumber(), user.getAddress(), user.getBankName(), user.getBankAccountNumber(), user.getBanKIfscCode(), user.isActive(),user.getRole());
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        }
    }

    //user login
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAccount(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        //check if email exists or not
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            User user = userRepository.findByEmail(userRequestDTO.getEmail());
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(), user.getPhone(), user.getAadharNumber(), user.getPanNumber(), user.getAddress(), user.getBankName(), user.getBankAccountNumber(), user.getBanKIfscCode(), user.isActive(),user.getRole());
            //matching passwords
            if (user.getPassword().equals(userRequestDTO.getPassword())) {
                return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid Password", HttpStatus.NOT_FOUND);
            }
        } else {
            //email doesn't exist
            return new ResponseEntity<>("Account does not exist. Please Sign up.", HttpStatus.NOT_FOUND);
        }
    }

    //List only Active Users
    @GetMapping(path = "/active")
    public List<UserResponseDTO> activeUsers() {

        List<User> userList = userRepository.findAllByActive(true);
        //Converting List of Entity to List of DTO
        return mapper.entityToDtoList(userList);
    }

    //List of Inactive Users
    @GetMapping(path = "/inactive")
    public List<UserResponseDTO> inactiveUsers() {
        List<User> userList = userRepository.findAllByActive(false);
        //Converting List of Entity to List of DTO
        return mapper.entityToDtoList(userList);
    }

    //List of Users Credential
    @GetMapping(path = "/credentials")
    public List<UserRequestDTO> credentials() {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserRequestDTO> userRequestDTOList = new ArrayList<>();
        for (User user : userList) {
            UserRequestDTO userRequestDTO = new UserRequestDTO(user.getUserId(), user.getEmail(), user.getPassword());
            userRequestDTOList.add(userRequestDTO);
        }
        return userRequestDTOList;
    }

    //Update User Details
    @PutMapping("/update-user")
    public UserResponseDTO updateUser(@RequestBody UserRequestDTO userRequestDTO) {

        //extracting user from db using userId
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


        //user is updated and then mapped to dto
        return mapper.entityToDto(userService.updateUser(userRequestDTO));
    }
}