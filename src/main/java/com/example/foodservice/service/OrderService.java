package com.example.foodservice.service;

import com.example.foodservice.dao.entity.ItemRequest;
import com.example.foodservice.dao.entity.Order;
import com.example.foodservice.dao.entity.OrderItem;
import com.example.foodservice.dao.entity.OrderRequest;
import com.example.foodservice.dao.repository.OrderItemRepository;
import com.example.foodservice.dao.repository.OrderRepository;
import com.example.foodservice.dto.ItemDtoResponse;
import com.example.foodservice.dto.OrderDtoResponse;
import com.example.foodservice.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


    public void createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        orderRepository.save(order);
        List<OrderItem> orderItems = new ArrayList<>();
        for (ItemRequest itemRequest : orderRequest.getItemRequestList()) {
            OrderItem orderedItem = new OrderItem();
            orderedItem.setOrderId(order.getId());
            orderedItem.setItemId(itemRequest.getItemId());
            orderedItem.setQuantity(itemRequest.getQuantity());
            orderItems.add(orderedItem);
            orderItemRepository.save(orderedItem);
        }
    }

    public OrderResponse getOrderDetails(long userId) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setUserId(userId);
        List<Order> orders = orderRepository.findByUserId(userId);
        ArrayList<OrderDtoResponse> orderDtoList = new ArrayList<>();
        for (Order order : orders) {
            OrderDtoResponse orderDto = new OrderDtoResponse();
            orderDto.setId(order.getId());
            orderDto.setPurchasedAt(order.getPurchasedAt());
            List<ItemDtoResponse> itemDtoList = new ArrayList<>();
            for (OrderItem item : orderItemRepository.findByOrderId(order.getId())) {
                ItemDtoResponse itemDto = new ItemDtoResponse();
                itemDto.setId(item.getId());
                itemDto.setQuantity(item.getQuantity());
                itemDtoList.add(itemDto);
            }
            orderDto.setItems(itemDtoList);
            orderDtoList.add(orderDto);
        }
        orderResponse.setOrders(orderDtoList);
        return orderResponse;
    }
}

