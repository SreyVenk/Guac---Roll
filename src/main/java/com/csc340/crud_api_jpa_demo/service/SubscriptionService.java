package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Subscription;
import com.csc340.crud_api_jpa_demo.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
}
