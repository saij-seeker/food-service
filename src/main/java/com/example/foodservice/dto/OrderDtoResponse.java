package com.example.foodservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDtoResponse {
    private long id;
    private LocalDateTime purchasedAt;
    private List<ItemDtoResponse> items;
}
