package com.example.foodservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDto {
    private long cartId;
    private long userId;
    private long restaurantId;
    private List<ItemDtoResponse> items;
}
