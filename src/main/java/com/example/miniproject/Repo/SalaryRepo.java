package com.example.miniproject.Repo;

import com.example.miniproject.Entity.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepo extends CrudRepository<Salary,Integer> {
}
