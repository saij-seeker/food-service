package com.example.foodservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private long userId;
    private List<OrderDtoResponse> orders;
}
