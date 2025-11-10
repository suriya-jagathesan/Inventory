package com.example.Inventory_Management.Inventory.Management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Table(name="products")
@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NonNull
    private String name;
    private int re_order_level;
}
