package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.CartRequest;
import com.example.foodservice.dao.entity.OrderRequest;
import com.example.foodservice.dto.CartDto;
import com.example.foodservice.dto.OrderResponse;
import com.example.foodservice.service.CartService;
import com.example.foodservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/cart")
    public void addItemToCart(@RequestBody CartRequest cartRequest) {
        cartService.addItemToCart(cartRequest);
    }

    @GetMapping("/cart")
    public ResponseEntity<CartDto> viewCart(@RequestParam(name="userId") long userId){
        return ResponseEntity.ok(cartService.getCartDetails(userId));
    }

    @DeleteMapping("/cart")
    public void deleteAllItems(@RequestParam(name="cart_id") long cartId){
        cartService.deleteCartItems(cartId);
    }
}
