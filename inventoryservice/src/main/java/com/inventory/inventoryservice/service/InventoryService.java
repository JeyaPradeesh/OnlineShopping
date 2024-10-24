package com.inventory.inventoryservice.service;

import com.inventory.inventoryservice.model.Inventory;
import com.inventory.inventoryservice.repo.InventoryrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryrRepo inventoryrRepo;

    public Inventory postInventory(Inventory inventory) {
       return inventoryrRepo.save(inventory);
    }
    public List<Inventory> viewInventory(){
        return inventoryrRepo.findAll();
    }

    public Inventory viewbyId(Long productId) {
        return inventoryrRepo.findByProductId(productId);
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        if (!inventoryrRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "inventory not found");
        }
        inventory.setId(id);
        return inventoryrRepo.save(inventory);
    }

    public void delete(Long productId) {
        Inventory inventory=inventoryrRepo.findByProductId(productId);
        if(inventory !=null) {
            inventoryrRepo.deleteById(productId);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "inventory not found");
        }
        }
    }
