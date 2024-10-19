package com.product.productservice.controller;

import com.product.productservice.model.Product;
import com.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public Product Create(@RequestBody Product product){
      return  productService.postProduct(product);
    }

    @GetMapping("/viewProduct")
     public List<Product> view()   {
        return productService.viewProduct();
    }

    @GetMapping("/viewById/{id}")
    public Optional<Product> viewById(@PathVariable("id") Long id)   {
        return productService.getProductById(id);
    }

}
