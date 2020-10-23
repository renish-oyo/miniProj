package com.example.miniproject.repository;

import com.example.miniproject.models.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<Users,Integer> {
}
