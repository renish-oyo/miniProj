package com.example.miniproject.repository;

import com.example.miniproject.models.entity.UserRoles;
import org.springframework.data.repository.CrudRepository;

public interface UserRolesRepo extends CrudRepository<UserRoles,Integer> {
}
