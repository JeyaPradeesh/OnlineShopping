package com.inventory.inventoryservice.controller;

import com.inventory.inventoryservice.model.Inventory;
import com.inventory.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public Inventory create(@RequestBody Inventory inventory){
        return inventoryService.postInventory(inventory);
    }

    @GetMapping("/view")
        public List<Inventory> view(){
            return inventoryService.viewInventory();
        }

    @GetMapping("/viewbyId/{productId}")
    public Inventory viewbyProductId(@PathVariable("productId") Long productId){
        return inventoryService.viewbyId(productId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory){
        Inventory inventory1=inventoryService.updateInventory(id,inventory);
        return ResponseEntity.ok(inventory1);
    }

    @DeleteMapping("/delete/{productId}")
    public String delete(@PathVariable("productId") Long productId){
        inventoryService.delete(productId);
        return "Deleted";
    }

}
