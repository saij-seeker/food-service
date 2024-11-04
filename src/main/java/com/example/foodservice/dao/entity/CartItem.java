package com.example.foodservice.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cartItems")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_Id", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "cart_Id", referencedColumnName = "id")
    private Cart cart;

    private long quantity;



}
