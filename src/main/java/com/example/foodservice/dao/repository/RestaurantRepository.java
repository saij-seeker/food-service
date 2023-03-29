package com.example.foodservice.dao.repository;

import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dto.RestaurantDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);
}
