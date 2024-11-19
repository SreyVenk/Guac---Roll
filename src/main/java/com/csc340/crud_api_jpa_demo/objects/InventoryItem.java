package com.csc340.crud_api_jpa_demo.objects;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_item")
public class InventoryItem{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventoryItemId;

    @Column(nullable = false)
    private String name;
    private int quantity;
    private double price;

    public InventoryItem(int inventoryItemId, String name, int quantity, double price) {
        this.inventoryItemId = inventoryItemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public InventoryItem(String name, int quantity, double price, boolean outOfStock) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public InventoryItem(){

    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getInventoryItemId(){
        return inventoryItemId;
    }
    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
