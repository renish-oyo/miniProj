package com.example.miniproject.controller;

import com.example.miniproject.mapper.Mapper;
import com.example.miniproject.mapper.UpdateMapper;
import com.example.miniproject.models.dto.CompanyDTO;
import com.example.miniproject.models.entity.Company;
import com.example.miniproject.repository.CompanyRepo;
import com.example.miniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/company")
public class CompanyController {

    private final CompanyRepo companyRepo;
    //Constructor injection is better than field injection
    @Autowired
    public CompanyController(UserService userService, CompanyRepo companyRepo, Mapper mapper, UpdateMapper updateMapper) {
        this.companyRepo=companyRepo;
    }

    //LOGGER FOR COMPANY REQUEST and RESPONSE
    private final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    // ADD NEW COMPANY API
    @PostMapping(path = "/add")
    public CompanyDTO addNewCompany(@RequestBody CompanyDTO companyDTO){
        ModelMapper modelMapper = new ModelMapper();
        Company company = companyRepo.save(modelMapper.map(companyDTO,Company.class));
        return modelMapper.map(company,CompanyDTO.class);
    }

    //GET LIST OF ALL COMPANIES
    @GetMapping(path = "/all")
    public List<CompanyDTO> allCompanies(){
        LOGGER.info("Listed all the companies.");
        List<Company> companyList = (List<Company>) companyRepo.findAll();
        // MAPPING Company List To CompanyDTO List
        ModelMapper modelMapper = new ModelMapper();
        Type companyDtoList = new TypeToken<List<CompanyDTO>>(){}.getType();
        final List<CompanyDTO> map = modelMapper.map(companyList, companyDtoList);
        return map;
    }

    @PutMapping(path = "/update")
    public CompanyDTO updateCompany(@RequestBody CompanyDTO companyDTO){
        ModelMapper modelMapper = new ModelMapper();
        Company company = companyRepo.save(modelMapper.map(companyDTO,Company.class));
        return modelMapper.map(company,CompanyDTO.class);
    }

    @DeleteMapping(path = "/delete")
    public String deleteCompany(@RequestParam(name = "comp_id") int companyId){
        if(companyRepo.existsById(companyId)){
            Optional<Company> company = companyRepo.findById(companyId);
            if(company.get().isActive()){
                companyRepo.setCompanyInactive(companyId);
                return "Company is now inactive.";
            }
            else
                return "Company is already inactive.";
        }
        else {
            return "Company with Id "+companyId+" does not exist.";
        }
    }

    @GetMapping("/all-dataset")
    public List<Company> listPage(){
        Pageable pageable = PageRequest.of(0,1);
        Page<Company> companyPage=companyRepo.findAll(pageable);
        return companyPage.getContent();
    }
}
