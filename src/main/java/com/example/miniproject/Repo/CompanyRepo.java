package com.example.miniproject.Repo;

import com.example.miniproject.Entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends CrudRepository<Company,Integer> {
}
