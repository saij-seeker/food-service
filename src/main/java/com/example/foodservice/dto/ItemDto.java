package com.example.foodservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private long id;
    private String name;
    private long price;
    private long restaurantId;
}
