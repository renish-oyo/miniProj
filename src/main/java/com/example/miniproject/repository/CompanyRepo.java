package com.example.miniproject.repository;
import com.example.miniproject.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    @Modifying
    @Query("update Company c set c.active=false where c.companyId = ?1")
    void setCompanyInactive(int comp_id);
}
