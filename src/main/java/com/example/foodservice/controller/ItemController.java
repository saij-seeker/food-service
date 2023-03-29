package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.Item;
import com.example.foodservice.dto.ItemDto;
import com.example.foodservice.dto.ItemDtoResponse;
import com.example.foodservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @DeleteMapping("/item")
    public void deleteItem(@RequestParam("id") int itemId) {
        itemService.deleteItem(itemId);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getItems(@RequestParam("restaurant_id") int restaurant_id) {
        return ResponseEntity.ok(itemService.getItems(restaurant_id));
    }
}
