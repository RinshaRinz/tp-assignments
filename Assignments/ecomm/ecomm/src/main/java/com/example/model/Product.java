package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String description;
    private double price;
    private boolean inStock;
    private double discountPercentage;

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }
}
