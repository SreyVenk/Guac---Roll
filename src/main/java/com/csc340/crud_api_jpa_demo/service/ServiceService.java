package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public void deleteService(int serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
