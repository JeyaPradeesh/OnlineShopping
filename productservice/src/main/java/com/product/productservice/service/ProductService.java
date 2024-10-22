package com.product.productservice.service;

import com.product.productservice.model.Product;
import com.product.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseEntity<List<Product>> getProductByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public String delete(Long id) {
         productRepo.deleteById(id);
         return "Deleted Succesfully";
    }

    public Product updateProduct(Long id, Product product) {
        if (!productRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        product.setId(id);
        return productRepo.save(product);
    }

}
