package Guac.N.Roll.Order;

import Guac.N.Roll.Cart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order updateOrderStatus(int orderId, String status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    public Order cancelOrder(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("Cancelled");
            return orderRepository.save(order);
        }
        return null;
    }

    public Order markOrderAsCompleted(int orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("Completed");
            return orderRepository.save(order);
        }
        return null;
    }

    public void createOrder(String customerName, String orderType, String deliveryAddress, List<CartItem> cart) {
        StringBuilder detailsBuilder = new StringBuilder();
        double total = 0;

        for (CartItem item : cart) {
            detailsBuilder.append(item.getProduct().getName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(", ");
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        String details = detailsBuilder.toString();
        if (details.endsWith(", ")) {
            details = details.substring(0, details.length() - 2);
        }

        Order order = new Order("Pending", details, customerName, total, orderType, "Delivery".equalsIgnoreCase(orderType) ? deliveryAddress : null);
        orderRepository.save(order);
    }

}
