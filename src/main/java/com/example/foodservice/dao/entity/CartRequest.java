package com.example.foodservice.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private long userId;
    private long restaurantId;
    private List<ItemRequest> itemRequestList;
}
