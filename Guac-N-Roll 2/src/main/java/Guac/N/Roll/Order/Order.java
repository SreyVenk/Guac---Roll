package Guac.N.Roll.Order;

import jakarta.persistence.*;
import Guac.N.Roll.Provider.Provider;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(nullable = false)
    private String status;
    private String details;

    public Order(int orderId, String status, String details) {
        this.orderId = orderId;
        this.status = status;
        this.details = details;
    }
    public Order(String status, String details) {
        this.status = status;
        this.details = details;
    }
    public Order() {

    }
    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String name) {
        this.status = status;
    }
    public String getDetails(){
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
