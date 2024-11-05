package com.example.foodservice.dao.repository;

import com.example.foodservice.dao.entity.Cart;
import com.example.foodservice.dao.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);

    void deleteByCart(Cart cart);
}
