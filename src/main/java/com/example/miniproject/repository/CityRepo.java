package com.example.miniproject.repository;

import com.example.miniproject.models.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepo extends CrudRepository<City,Integer> {
    List<City> findByStateStateId(int state_id);
}