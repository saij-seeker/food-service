package com.example.foodservice.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_Id", referencedColumnName = "id")
    private Restaurant restaurant;
}
