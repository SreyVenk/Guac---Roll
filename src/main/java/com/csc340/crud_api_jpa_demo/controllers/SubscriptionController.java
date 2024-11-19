package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.Subscription;
import com.csc340.crud_api_jpa_demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")  // Ensures the base path is /api
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/subscriptions")  // This maps to /api/subscriptions
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }
}
