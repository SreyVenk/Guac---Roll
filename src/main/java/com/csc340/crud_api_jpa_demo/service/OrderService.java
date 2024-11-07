package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Order;
import com.csc340.crud_api_jpa_demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private  OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(int orderId){
        return orderRepository.findById(orderId).orElse(null);
    }
    public void updateOrder(int orderId, Order order){
        Order existing = getOrderById(orderId);
        existing.setDetails(order.getDetails());
        existing.setStatus(order.getStatus());

        orderRepository.save(existing);
    }
    public void cancelOrderById(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
