package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.Distributor;
import com.csc340.crud_api_jpa_demo.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/distributor")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    // Get all distributors
    @GetMapping
    public List<Distributor> getAllDistributors() {
        return distributorService.getAllDistributors();
    }

    // Get a distributor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Distributor> getDistributorById(@PathVariable int id) {
        try {
            Distributor distributor = distributorService.getDistributorById(id);
            return ResponseEntity.ok(distributor);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new distributor
    @PostMapping
    public Distributor createDistributor(@RequestBody Distributor distributor) {
        return distributorService.saveDistributor(distributor);
    }

    // Update an existing distributor
    @PutMapping("/{id}")
    public ResponseEntity<Distributor> updateDistributor(@PathVariable int id, @RequestBody Distributor updatedDistributor) {
        try {
            Distributor distributor = distributorService.updateDistributor(id, updatedDistributor);
            return ResponseEntity.ok(distributor);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a distributor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistributor(@PathVariable int id) {
        try {
            distributorService.deleteDistributor(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
