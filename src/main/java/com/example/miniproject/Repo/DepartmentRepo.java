package com.example.miniproject.Repo;

import com.example.miniproject.Entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends CrudRepository<Department,Integer> {
}
