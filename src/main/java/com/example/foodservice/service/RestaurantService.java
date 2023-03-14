package com.example.foodservice.service;

import com.example.foodservice.dto.model.Restaurant;
import com.example.foodservice.dto.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
    public List<Restaurant> getRestaurantsDetails(){
        return restaurantRepository.findAll();
    }

}
