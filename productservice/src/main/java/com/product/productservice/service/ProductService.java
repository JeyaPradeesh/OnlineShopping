package com.product.productservice.service;

import com.product.productservice.model.Product;
import com.product.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product postProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> viewProduct() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }
}
