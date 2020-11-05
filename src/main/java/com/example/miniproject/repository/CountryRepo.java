package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<Country,Integer>{
}