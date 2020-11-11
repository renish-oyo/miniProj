package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    boolean existsByEmail(String email);


    @Modifying
    @Query("update Employee e set e.active=false where e.employeeId= ?1")
    void setEmployeeInactive(int emp_id);

}
