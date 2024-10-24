package com.priceservice.price.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "price")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Double price;
}
