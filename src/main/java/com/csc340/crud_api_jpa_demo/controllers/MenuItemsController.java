package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.MenuItems;
import com.csc340.crud_api_jpa_demo.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItems")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @GetMapping
    public List<MenuItems> getAllMenuItems() {
        return menuItemsService.getAllMenuItems();
    }

    @PostMapping
    public MenuItems createMenuItem(@RequestBody MenuItems menuItems) {
        return menuItemsService.saveMenuItem(menuItems);
    }

    @PutMapping("/{id}")
    public MenuItems updateMenuItem(@PathVariable int id, @RequestBody MenuItems menuItemsDetails) {
        return menuItemsService.updateMenuItem(id, menuItemsDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable int id) {
        menuItemsService.deleteMenuItem(id);
    }
}