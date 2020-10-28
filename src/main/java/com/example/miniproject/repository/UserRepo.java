package com.example.miniproject.repository;

import com.example.miniproject.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}
