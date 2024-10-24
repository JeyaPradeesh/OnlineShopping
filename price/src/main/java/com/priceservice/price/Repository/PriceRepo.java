package com.priceservice.price.Repository;

import com.priceservice.price.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    Price findByProductId(Long productId);
}
