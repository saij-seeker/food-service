package com.example.foodservice.service;

import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dao.repository.RestaurantRepository;
import com.example.foodservice.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public List<RestaurantDto> getRestaurantsDetails() {
        List<RestaurantDto> restaurantDtoList = new ArrayList<RestaurantDto>();
        List<Restaurant> restaurantEntityList = restaurantRepository.findAll();
        for (Restaurant restaurant : restaurantEntityList) {
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setId(restaurant.getId());
            restaurantDto.setName(restaurant.getName());
            restaurantDto.setAddress(restaurant.getAddress());
            restaurantDtoList.add(restaurantDto);
        }
        return restaurantDtoList;
    }

    public ResponseEntity<Restaurant> updateRestaurant(long id, @RequestBody Restaurant updatedRestaurant) {

        RestaurantDto restaurantDto = new RestaurantDto();
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
        Restaurant restaurant = null;
        if (existingRestaurant.isPresent()) {
            {
                restaurant = existingRestaurant.get();
                restaurant.setName(updatedRestaurant.getName());
                restaurant.setAddress(updatedRestaurant.getAddress());
            }
            return ResponseEntity.ok(restaurantRepository.save(restaurant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<RestaurantDto> getRestaurantDetailsById(long id) {
        RestaurantDto restaurantDto = new RestaurantDto();
        Optional<Restaurant> restaurantEntity = restaurantRepository.findById(id);
        if (restaurantEntity.isPresent()) {
            {
                Restaurant restaurant = restaurantEntity.get();
                restaurantDto.setId(restaurant.getId());
                restaurantDto.setName(restaurant.getName());
                restaurantDto.setAddress(restaurant.getAddress());
            }
            ;
            return ResponseEntity.ok(restaurantDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public List<RestaurantDto> getRestaurantsDetailsByName(String name) {
        List<RestaurantDto> restaurantDtoList = new ArrayList<RestaurantDto>();
        List<Restaurant> restaurantEntityList = restaurantRepository.findByName(name);
        for (Restaurant restaurant : restaurantEntityList) {
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setId(restaurant.getId());
            restaurantDto.setName(restaurant.getName());
            restaurantDto.setAddress(restaurant.getAddress());
            restaurantDtoList.add(restaurantDto);
        }
        return restaurantDtoList;
    }
}
