package com.example.foodservice.controller;

import com.example.foodservice.dao.entity.User;
import com.example.foodservice.dto.UserDto;
import com.example.foodservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam("id") int userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

}
