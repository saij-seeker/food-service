package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dto.RestaurantDto;
import com.example.foodservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
      // return new ResponseEntity<String>(restaurantService.addRestaurant(restaurant),HttpStatus.OK);
    }

    @GetMapping("/restaurantById")
    public ResponseEntity<RestaurantDto> getRestaurantById(@RequestParam("id") long id) {
        return new ResponseEntity<RestaurantDto>(restaurantService.getRestaurantDetailsById(id), HttpStatus.OK);
    }

    @GetMapping("/restaurantByName")
    public ResponseEntity<List<RestaurantDto>> getRestaurantByName(@RequestParam("name") String name) {
        return new ResponseEntity<List<RestaurantDto>>(restaurantService.getRestaurantsDetailsByName(name), HttpStatus.OK);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants() {
        return new ResponseEntity<List<RestaurantDto>>(restaurantService.getRestaurantsDetails(), HttpStatus.OK);
    }
}
