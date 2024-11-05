package com.example.foodservice.service;

import com.example.foodservice.dao.entity.*;
import com.example.foodservice.dao.repository.CartItemRepository;
import com.example.foodservice.dao.repository.CartRepository;
import com.example.foodservice.dto.CartDto;
import com.example.foodservice.dto.ItemDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

   @Transactional
    public void deleteCartItems(long cartId) {
        Optional<Cart> existingCart = cartRepository.findById(cartId);
        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
           cartItemRepository.deleteByCart(cart);
           cartRepository.deleteById(cartId);
        }
    }

    public void addItemToCart(CartRequest cartRequest) {
        Cart cart = new Cart();
        User user = new User();
        user.setId(cartRequest.getUserId());
        List<Cart> cartList = cartRepository.findByUser(user);
        if (cartList.isEmpty()) {
            cart.setUser(user);
            Restaurant restaurant = new Restaurant();
            restaurant.setId(cartRequest.getRestaurantId());
            cart.setRestaurant(restaurant);
            cartRepository.save(cart);
            List<CartItem> cartItems = new ArrayList<>();
            for (ItemRequest itemRequest : cartRequest.getItemRequestList()) {
                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                Item item = new Item();
                item.setId(itemRequest.getItemId());
                cartItem.setItem(item);
                cartItem.setQuantity(itemRequest.getQuantity());
                cartItems.add(cartItem);
                cartItemRepository.save(cartItem);
            }
        } else {
            Cart existingCart = cartList.get(0);
            List<CartItem> existingCartItems = cartItemRepository.findByCart(existingCart);
            for (CartItem existingCartItem : existingCartItems) {
                Item existingItem = existingCartItem.getItem();
                for (ItemRequest itemRequest : cartRequest.getItemRequestList()) {
                    if (existingItem.getId() == itemRequest.getItemId()) {
                        existingCartItem.setQuantity(itemRequest.getQuantity());
                        cartItemRepository.save(existingCartItem);
                    } else {
                        Item item = new Item();
                        item.setId(itemRequest.getItemId());
                        CartItem cartItem = new CartItem();
                        cartItem.setCart(existingCart);
                        cartItem.setItem(item);
                        cartItem.setQuantity(itemRequest.getQuantity());
                        cartItemRepository.save(cartItem);
                    }
                }
            }
        }
    }

    public CartDto getCartDetails(long userId) {
        CartDto response = new CartDto();
        Cart cart = new Cart();
        User user = new User();
        user.setId(userId);
        response.setUserId(userId);
        List<Cart> cartList = cartRepository.findByUser(user);
        if (!cartList.isEmpty()) {
            Cart existingCart = cartList.get(0);
            long cartId = existingCart.getId();
            response.setCartId(cartId);
            response.setRestaurantId(existingCart.getRestaurant().getId());
            List<ItemDtoResponse> itemDtoList = new ArrayList<>();
            List<CartItem> existingCartItems = cartItemRepository.findByCart(existingCart);
            for (CartItem cartItem : existingCartItems) {
                ItemDtoResponse itemDto = new ItemDtoResponse();
                itemDto.setId(cartItem.getItem().getId());
                itemDto.setQuantity(cartItem.getQuantity());
                itemDtoList.add(itemDto);
            }
            response.setItems(itemDtoList);
        }
        return response;
    }
}
