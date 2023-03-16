package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dto.RestaurantDto;
import com.example.foodservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
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
    }

    @RequestMapping(value = "/restaurant", params = "id",method=RequestMethod.GET)
    public ResponseEntity<RestaurantDto> getRestaurantById(@RequestParam(name = "id") long id) {
        return restaurantService.getRestaurantDetailsById(id);
    }

    @RequestMapping(value = "/restaurant", params = "name", method=RequestMethod.GET)
    public ResponseEntity<List<RestaurantDto>> getRestaurantByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(restaurantService.getRestaurantsDetailsByName(name));
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants() {
        return ResponseEntity.ok(restaurantService.getRestaurantsDetails());
    }
}
