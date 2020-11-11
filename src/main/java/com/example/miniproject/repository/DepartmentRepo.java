package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DepartmentRepo extends CrudRepository<Department,Integer> {
    List<Department> findAll();

    @Modifying
    @Query("update Department d set d.active=false where d.departmentId = ?1")
    void setDepartmentInactive(int dept_id);
}
