package com.product.productservice.controller;

import com.product.productservice.model.Product;
import com.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
        return productService.getProductByCategory(category);
    }

    @PostMapping("/createProduct")
    public Product Create(@RequestBody Product product){
      return  productService.postProduct(product);
    }

    @GetMapping("/viewProduct")
     public List<Product> view()   {
        return productService.viewProduct();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
        Product product1=productService.updateProduct(id,product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/viewById/{id}")
    public Optional<Product> viewById(@PathVariable("id") Long id)   {
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
         productService.delete(id);
         return "Deleted";
    }

}
