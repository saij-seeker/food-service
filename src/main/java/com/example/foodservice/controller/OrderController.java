package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.OrderRequest;
import com.example.foodservice.dto.OrderResponse;
import com.example.foodservice.dto.RestaurantDto;
import com.example.foodservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public void orderItems(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
    }

    @GetMapping("/orders")
    public ResponseEntity<OrderResponse> viewOrders(@RequestParam(name="userId") long userId){
        return ResponseEntity.ok(orderService.getOrderDetails(userId));
    }


}
