package com.csc340.crud_api_jpa_demo.service;


import com.csc340.crud_api_jpa_demo.objects.MenuItems;
import com.csc340.crud_api_jpa_demo.repository.MenuItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsService {

    @Autowired
    private MenuItemsRepository menuItemsRepository;

    public List<MenuItems> getAllMenuItems() {
        return menuItemsRepository.findAll();
    }

    public MenuItems saveMenuItem(MenuItems menuItems) {
        return menuItemsRepository.save(menuItems);
    }

    public MenuItems updateMenuItem(int id, MenuItems menuItemsDetails) {
        MenuItems menuItems = menuItemsRepository.findById(id).orElseThrow();
        menuItems.setItemName(menuItemsDetails.getItemName());
        menuItems.setPrice(menuItemsDetails.getPrice());
        menuItems.setPointsEarned(menuItemsDetails.getPointsEarned());
        menuItems.setRewardsPrice(menuItemsDetails.getRewardsPrice());
        return menuItemsRepository.save(menuItems);
    }

    public void deleteMenuItem(int id) {
        menuItemsRepository.deleteById(id);
    }
}
