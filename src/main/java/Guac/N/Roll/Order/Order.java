package Guac.N.Roll.Order;

import Guac.N.Roll.Driver.Driver;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(nullable = false)
    private String status = "Pending";

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private String orderType;

    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver assignedDriver;

    public Order() {}

    public Order(String status, String details, String customerName, double total, String orderType, String deliveryAddress) {
        this.status = status;
        this.details = details;
        this.customerName = customerName;
        this.total = total;
        this.orderType = orderType;
        this.deliveryAddress = deliveryAddress;
    }

    // Getters and Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Driver getAssignedDriver() {
        return assignedDriver;
    }

    public void setAssignedDriver(Driver assignedDriver) {
        this.assignedDriver = assignedDriver;
    }
}
