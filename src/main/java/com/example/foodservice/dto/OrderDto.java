package com.example.foodservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {
    private long id;
    private long userId;
    private LocalDateTime purchasedAt;
}
