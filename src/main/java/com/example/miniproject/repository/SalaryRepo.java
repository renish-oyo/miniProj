package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Salary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SalaryRepo extends CrudRepository<Salary,Integer> {
    @Modifying
    @Query("update Salary s set s.active=false where s.salaryId=?1")
    void setSalaryInactive(int salary_id);

    @Modifying
    @Query("update Salary s set s.salaryAmount= (s.salaryAmount + s.salaryAmount * ?2) where  s.department.departmentId=?1")
    void salaryIncrement(int deptId,float incrementPercent);
}
