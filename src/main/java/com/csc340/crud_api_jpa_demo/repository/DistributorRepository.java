package com.csc340.crud_api_jpa_demo.repository;

import com.csc340.crud_api_jpa_demo.objects.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    // Add custom query methods if necessary
}