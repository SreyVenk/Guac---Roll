package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.InventoryItem;
import com.csc340.crud_api_jpa_demo.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }
    public InventoryItem getInventoryItemById(int inventoryItemId){
        return inventoryItemRepository.findById(inventoryItemId).orElse(null);
    }
    public void addNewInventoryItem(InventoryItem item) {
        inventoryItemRepository.save(item);
    }
    public void updateInventoryItem(int inventoryItemId, InventoryItem item) {
        InventoryItem existing = getInventoryItemById(inventoryItemId);
        existing.setName(item.getName());
        existing.setPrice(item.getPrice());
        existing.setQuantity(item.getQuantity());

        inventoryItemRepository.save(existing);
    }
    public void deleteInventoryItemById(int inventoryItemId){
        inventoryItemRepository.deleteById(inventoryItemId);
    }

}

