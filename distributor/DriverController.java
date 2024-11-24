package com.csc340.crud_api_jpa_demo.controllers;


import com.csc340.crud_api_jpa_demo.objects.Driver;
import com.csc340.crud_api_jpa_demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Get all drivers
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    // Get a driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable int id) {
        Driver driver = driverService.findById(id);
        if (driver != null) {
            return ResponseEntity.ok(driver);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new driver
    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    // Update a driver by ID
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable int id, @RequestBody Driver updatedDriver) {
        Driver driver = driverService.findById(id);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        }

        // Update driver details
        driver.setName(updatedDriver.getName());
        driver.setCar(updatedDriver.getCar());
        driver.setAge(updatedDriver.getAge());

        driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
    }

}

