package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Driver;
import com.csc340.crud_api_jpa_demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Method to retrieve all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Method to save a new driver
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Method to update an existing driver
    public Driver updateDriver(int id, Driver driverDetails) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Driver not found with id: " + id));
        driver.setName(driverDetails.getName());
        driver.setCar(driverDetails.getCar());
        driver.setAge(driverDetails.getAge());
        return driverRepository.save(driver);
    }

    // Method to delete a driver by ID
    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }

    // Method to find a driver by ID
    public Driver findById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    // Method to save a driver (if needed as a utility)
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }
}
