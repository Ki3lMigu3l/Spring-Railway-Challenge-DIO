package com.dio.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;
    private double price;
}
