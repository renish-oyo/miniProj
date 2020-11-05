package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    boolean existsByEmail(String email);
}
