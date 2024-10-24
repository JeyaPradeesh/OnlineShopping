package com.priceservice.price.service;

import com.priceservice.price.Repository.PriceRepo;
import com.priceservice.price.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepo priceRepo;

    public Optional<Price> getPriceByProductId(Long productId) {
        return priceRepo.findById(productId);
    }

    public List<Price> viewPrice() {
        return priceRepo.findAll();
    }

    public Price addPrice(Price price) {
        return priceRepo.save(price);
    }

    public Price updatePrice(Long productId, Price price) {
        Price existingPrice = priceRepo.findByProductId(productId);
        if (existingPrice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price Not Found for Product Id" + productId);
        }
        existingPrice.setPrice(price.getPrice());
        return priceRepo.save(existingPrice);
    }

    public void deletePrice(Long productId) {
        Price price = priceRepo.findByProductId(productId);
        if (price != null) {
            priceRepo.delete(price);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found Price for ProductId");
        }
    }

}
