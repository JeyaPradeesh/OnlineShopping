package com.inventory.inventoryservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="inventory")
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Integer availableStock;

}
