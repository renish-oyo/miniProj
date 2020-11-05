package com.example.miniproject.controller;

import com.example.miniproject.models.dto.CityDTO;
import com.example.miniproject.models.dto.CountryDTO;
import com.example.miniproject.models.dto.StateDTO;
import com.example.miniproject.models.entity.City;
import com.example.miniproject.models.entity.Country;
import com.example.miniproject.models.entity.State;
import com.example.miniproject.repository.CityRepo;
import com.example.miniproject.repository.CountryRepo;
import com.example.miniproject.repository.StateRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/location")
public class LocationController {

    private final CountryRepo countryRepo;
    private final StateRepo stateRepo;
    private final CityRepo cityRepo;


    @Autowired
    public LocationController(CountryRepo countryRepo,StateRepo stateRepo,CityRepo cityRepo){
        this.countryRepo=countryRepo;
        this.stateRepo=stateRepo;
        this.cityRepo=cityRepo;
    }

    @GetMapping(path = "/countries")
    public List<CountryDTO> fetchCountries(){
        List<Country> countryList = (List<Country>) countryRepo.findAll();

        // MAPPING Country_LIST TO CountryDTO_LIST
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<CountryDTO>>(){}.getType();
        return modelMapper.map(countryList,listType);
    }

    @GetMapping(path = "/states")
    public List<StateDTO> fetchStates(@RequestParam int country_id){
        List<State> stateList = stateRepo.findByCountryCountryId(country_id);

        // MAPPING State_LIST TO StateDTO_LIST
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<StateDTO>>(){}.getType();
        return modelMapper.map(stateList,listType);
    }

    @GetMapping(path = "/cities")
    public List<CityDTO> fetchCities(@RequestParam int state_id){
        List<City> cityList = cityRepo.findByStateStateId(state_id);

        // MAPPING State_LIST TO StateDTO_LIST
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<CityDTO>>(){}.getType();
        return modelMapper.map(cityList,listType);
    }

}
