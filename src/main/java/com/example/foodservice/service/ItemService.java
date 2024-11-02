package com.example.foodservice.service;

import com.example.foodservice.dao.entity.Item;
import com.example.foodservice.dao.entity.Restaurant;
import com.example.foodservice.dao.repository.ItemRepository;
import com.example.foodservice.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<ItemDto> getItems(long restaurant_id) {
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        List<Item> itemEntityList = itemRepository.findItemsByRestaurantId(restaurant_id);
        for (Item item : itemEntityList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setName(item.getName());
            itemDto.setPrice(item.getPrice());
            Restaurant restaurant=item.getRestaurant();
            itemDto.setRestaurantId(restaurant.getId());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }


}
