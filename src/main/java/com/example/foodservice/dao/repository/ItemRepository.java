package com.example.foodservice.dao.repository;

import com.example.foodservice.dao.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i WHERE i.restaurant.id= :restaurantId")
    List<Item> findItemsByRestaurantId(@Param("restaurantId") long restaurantId);

    List<Item> findByName(String itemName);

}
