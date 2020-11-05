package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepo extends CrudRepository<Department,Integer> {
    List<Department> findAll();
}
