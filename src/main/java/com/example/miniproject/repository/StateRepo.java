package com.example.miniproject.repository;

import com.example.miniproject.models.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StateRepo extends CrudRepository<State,Integer>{

    List<State> findByCountryCountryId(int country_id);
}
