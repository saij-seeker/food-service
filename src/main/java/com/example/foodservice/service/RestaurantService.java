package com.example.foodservice.service;

import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dao.repository.RestaurantRepository;
import com.example.foodservice.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public RestaurantDto getRestaurantDetailsById(long id) {
        RestaurantDto restaurantDto = new RestaurantDto();
        Optional<Restaurant> restaurantEntity = restaurantRepository.findById(id);
        restaurantEntity.ifPresent(restaurant ->
        {
            restaurantDto.setId(restaurant.getId());
            restaurantDto.setName(restaurant.getName());
            restaurantDto.setAddress(restaurant.getAddress());
        });
        return restaurantDto;

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
