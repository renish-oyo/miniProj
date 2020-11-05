package com.example.miniproject.controller;

import com.example.miniproject.models.entity.Designation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/enum")
public class EnumController {
    @GetMapping("/designation")
    public Designation[] designation(){
        return Designation.values();
    }
}