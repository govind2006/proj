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
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product,MultipartFile image) throws IOException {
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct != null) {
            product.setImageData(image.getBytes());
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            return repo.save(existingProduct);
        }
        return null;
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
    
}