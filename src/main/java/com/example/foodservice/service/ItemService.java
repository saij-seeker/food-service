package com.example.foodservice.service;

import com.example.foodservice.dao.entity.Item;
import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dao.repository.ItemRepository;
import com.example.foodservice.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public ResponseEntity<Item> updateItem(long itemId, Item updatedItem) {
        Optional<Item> existingItem = itemRepository.findById(itemId);
        Item item = null;
        if (existingItem.isPresent()) {
            item = existingItem.get();
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            item.setRestaurant(updatedItem.getRestaurant());
            return ResponseEntity.ok(itemRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<ItemDto> getItems() {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemEntityList = itemRepository.findAll();
        for (Item item : itemEntityList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setName(item.getName());
            itemDto.setPrice(item.getPrice());
            Restaurant restaurant = item.getRestaurant();
            itemDto.setRestaurantId(restaurant.getId());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public List<ItemDto> getItems(long restaurant_id) {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemEntityList = itemRepository.findItemsByRestaurantId(restaurant_id);
        for (Item item : itemEntityList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setName(item.getName());
            itemDto.setPrice(item.getPrice());
            Restaurant restaurant = item.getRestaurant();
            itemDto.setRestaurantId(restaurant.getId());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public List<ItemDto> getItems(String itemName) {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemEntityList = itemRepository.findByName(itemName);
        for (Item item : itemEntityList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setName(item.getName());
            itemDto.setPrice(item.getPrice());
            Restaurant restaurant = item.getRestaurant();
            itemDto.setRestaurantId(restaurant.getId());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }


}
