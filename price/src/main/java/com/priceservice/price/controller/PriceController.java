package com.priceservice.price.controller;

import com.priceservice.price.model.Price;
import com.priceservice.price.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/{productId}")
    public Optional<Price> getPriceByProductId(@PathVariable Long productId){
        return priceService.getPriceByProductId(productId);
    }

    @GetMapping("/view")
    public List<Price> view(){
     return priceService.viewPrice();
    }

    @PostMapping("/add")
    public Price addPrice(@RequestBody Price price){
        return priceService.addPrice(price);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long productId,@RequestBody Price price){
        Price updatedPrice=priceService.updatePrice(productId,price);
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/delete/{productId}")
    public String deletePrice(@PathVariable Long productId){
     priceService.deletePrice(productId);
     return "Deleted Successfully";
    }
}
