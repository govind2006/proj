package com.example.ecom_proj.service;

import com.example.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecom_proj.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;


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

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        // Assuming you have logic to handle the image file
        // Save the image and set the path in the product object
        // For now, just save the product without image handling
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }
    
}