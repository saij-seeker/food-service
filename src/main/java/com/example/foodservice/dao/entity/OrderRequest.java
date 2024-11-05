package com.example.foodservice.dao.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
private long userId;
private List<ItemRequest> itemRequestList;

}
