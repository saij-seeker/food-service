package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.Item;
import com.example.foodservice.dto.ItemDto;
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

    @PutMapping("/item")
    public ResponseEntity<ItemDto> updateItem(@RequestParam("id") int itemId, @RequestBody ItemDto item) {
        return itemService.updateItem(itemId, item);
    }

    @RequestMapping(value = "/items", params = "restaurant_id", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDto>> getItems(@RequestParam("restaurant_id") int restaurant_id) {
        return ResponseEntity.ok(itemService.getItems(restaurant_id));
    }

    @RequestMapping(value = "/items", params = "name", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDto>> getItems(@RequestParam("name") String itemName) {
        return ResponseEntity.ok(itemService.getItems(itemName));
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }
}
