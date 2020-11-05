package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.dto.ResponseDTO;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.UserRepository;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final Mapper mapper;
    private final UpdateMapper updateMapper;

    //Constructor injection is better than field injection
    @Autowired
    public UserController(UserService userService, UserRepository userRepository, Mapper mapper,UpdateMapper updateMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.updateMapper=updateMapper;
    }

    //Temporary path to check users saved in User Table
    @GetMapping(path = "/list")
    public List<User> allUsersList() {
        return (List<User>) userRepository.findAll();
    }

    //user create account
    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> createAccount(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.saveUser(userDTO);
        //user returns null when Account already exists.
        if (user == null) {
            return new ResponseEntity<>("Account already exists. Please Login", HttpStatus.OK);
        } else {
            ModelMapper modelMapper = new ModelMapper();
            ResponseDTO responseDTO = modelMapper.map(user,ResponseDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
    }

    //user login
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAccount(@Valid @RequestBody UserDTO userDTO) {
        //check if email exists or not
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            User user = userRepository.findByEmail(userDTO.getEmail());
            ModelMapper modelMapper = new ModelMapper();
            ResponseDTO responseDTO = modelMapper.map(user,ResponseDTO.class);
            //matching passwords
            if (user.getPassword().equals(userDTO.getPassword())) {
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
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
    public List<ResponseDTO> activeUsers() {
        List<User> userList = userRepository.findAllByActive(true);
        //Converting List of Entity to List of DTO
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<ResponseDTO>>(){}.getType();
        return modelMapper.map(userList,listType);
    }

    //List of Inactive Users
    @GetMapping(path = "/inactive")
    public List<ResponseDTO> inactiveUsers() {
        List<User> userList = userRepository.findAllByActive(false);
        //Converting List of Entity to List of DTO
        return mapper.entityToDtoList(userList);
    }

    //List of Users Credential
    @GetMapping(path = "/credentials")
    public List<UserDTO> credentials() {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO(user.getUserId(), user.getEmail(), user.getPassword());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }



    //upload image to Database
    @PutMapping("/upload")
    public ResponseEntity<?> uploadImage (@RequestParam int user_id,@RequestBody MultipartFile image) throws IOException {

        System.out.println("Size : "+ image.getSize());
        if(image.getSize() < 1048000) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user_id);
            userDTO.setImage(image.getBytes());
            System.out.println(userDTO);

            userDTO = updateMapper.map(userDTO);

            User user = userRepository.save(mapper.dtoToEntity(userDTO));
            System.out.println(mapper.entityToDto(user));
            return new ResponseEntity<>(mapper.entityToDto(user), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Image Size Should Be Less Than 1MB.",HttpStatus.OK);
        }
    }

    //Update User Details
    @PutMapping("/update-user")
    public ResponseDTO updateUser(@RequestBody UserDTO userDTO) {
        userDTO =updateMapper.map(userDTO);
        System.out.println(userDTO);
        return mapper.entityToDto(userService.updateUser(userDTO));
    }
}