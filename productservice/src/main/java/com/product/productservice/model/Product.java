package com.product.productservice.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String brand;
        private String description;
        private double price;
        private int inventory;
        private String category;
}

