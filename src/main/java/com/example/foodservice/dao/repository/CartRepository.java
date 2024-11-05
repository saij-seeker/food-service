package com.example.foodservice.dao.repository;

import com.example.foodservice.dao.entity.Cart;
import com.example.foodservice.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}
