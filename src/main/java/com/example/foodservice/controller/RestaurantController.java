package com.example.foodservice.controller;

import com.example.foodservice.dto.model.Restaurant;
import com.example.foodservice.service.RestaurantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;
    @PostMapping("/addRestaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/restaurants")
    public String getRestaurants() {
      return new Gson().toJson(restaurantService.getRestaurantsDetails());

    }
}
