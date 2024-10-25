package com.inventory.inventoryservice.service;

import com.inventory.inventoryservice.model.Inventory;
import com.inventory.inventoryservice.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryrRepo;

    public Inventory postInventory(Inventory inventory) {
       return inventoryrRepo.save(inventory);
    }

    public List<Inventory> viewInventory(){
        return inventoryrRepo.findAll();
    }

    public Optional<Inventory> viewByProductId(Long productId) {
            return Optional.ofNullable(inventoryrRepo.findByProductId(productId));
        }

    public Inventory updateInventory(Long id, Inventory inventory) {
        if (!inventoryrRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "inventory not found");
        }
        inventory.setId(id);
        return inventoryrRepo.save(inventory);
    }

    public void delete(Long productId) {
        Inventory inventory =inventoryrRepo.findByProductId(productId);
        if(inventory != null){
            inventoryrRepo.delete(inventory);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Price not found for ProductId");
        }
    }

}
