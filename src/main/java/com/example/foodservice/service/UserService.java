package com.example.foodservice.service;


import com.example.foodservice.dao.entity.User;
import com.example.foodservice.dao.repository.UserRepository;
import com.example.foodservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
    public List<UserDto> getUsers() {
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        List<User> userEntityList = userRepository.findAll();
        for (User user : userEntityList) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setAddress(user.getAddress());
            userDto.setContact(user.getContact());
            userDto.setMailId(user.getMailId());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }


}
