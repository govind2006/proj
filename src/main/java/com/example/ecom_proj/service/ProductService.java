package com.example.ecom_proj.service;

import com.example.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecom_proj.model.Product;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {
    // Add methods and logic for ProductService here
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }
    
}