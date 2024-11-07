package com.csc340.crud_api_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csc340.crud_api_jpa_demo.objects.InventoryItem;
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {

}
