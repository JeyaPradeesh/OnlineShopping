package com.product.productservice.repo;

import com.product.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

   ResponseEntity<List<Product>> findByCategory(String category);
}
