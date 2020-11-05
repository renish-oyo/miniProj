package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Company;
import com.example.miniproject.models.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends CrudRepository<Company,Integer> {

}
