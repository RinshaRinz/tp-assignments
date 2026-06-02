package com.example.product_inventory.service;

import com.example.product_inventory.entity.Product;
import com.example.product_inventory.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public String addProduct(Product p) {
        if (p.getPrice() < 0) {
            return "Invalid Price";
        }

        if (p.getQuantity() < 0) {
            return "Invalid Quantity";
        }
        repo.save(p);
        return "Product added successfully";
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public String updateQuantity(Long id, int quantity) {

        if (quantity < 0) {
            return "Invalid Quantity";
        }

        Product product = repo.findById(id).orElse(null);

        if (product != null) {
            product.setQuantity(quantity);
            repo.save(product);
            return "Quantity updated successfully";
        }
        return "Product not found";
    }

    public String deleteProduct(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }


}
