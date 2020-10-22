package com.example.miniproject.repository;

import com.example.miniproject.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends CrudRepository<Company,Integer> {
}
