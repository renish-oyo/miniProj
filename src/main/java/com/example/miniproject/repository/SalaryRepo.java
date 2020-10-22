package com.example.miniproject.repository;

import com.example.miniproject.entity.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends CrudRepository<Salary,Integer> {
}
