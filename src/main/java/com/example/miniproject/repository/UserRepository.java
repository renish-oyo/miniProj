package com.example.miniproject.repository;

import com.example.miniproject.models.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    List<User> findAllByActive(boolean active);

}
