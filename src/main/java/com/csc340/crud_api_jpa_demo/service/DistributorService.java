package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Distributor;
import com.csc340.crud_api_jpa_demo.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    // Retrieve all distributors
    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    // Retrieve a distributor by ID
    public Distributor getDistributorById(int id) {
        return distributorRepository.findById(id).orElse(null);
    }

    // Create a new distributor
    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    // Update an existing distributor
    public Distributor updateDistributor(int id, Distributor updatedDistributor) {
        Optional<Distributor> existingDistributor = distributorRepository.findById(id);
        if (existingDistributor.isPresent()) {
            Distributor distributor = existingDistributor.get();
            distributor.setName(updatedDistributor.getName());
            // Update other fields as necessary
            return distributorRepository.save(distributor);
        }
        return null;
    }

    // Delete a distributor by ID
    public void deleteDistributor(int id) {
        distributorRepository.deleteById(id);
    }
}
