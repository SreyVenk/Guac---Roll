package Guac.N.Roll.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderContoller {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllStudents() {
        return orderService.getAllOrders();
    }
    @GetMapping("/{orderId}")
    public Order getOneStudent(@PathVariable int orderId){
        return orderService.getOrderById(orderId);
    }
    @PutMapping("/update/{orderId}")
    public Order updateOrder(@PathVariable int orderId, @RequestBody Order order){
        orderService.updateOrder(orderId, order);
        return orderService.getOrderById(orderId);
    }
    @DeleteMapping("/cancel/{orderId}")
    public List<Order> cancelOrderById(@PathVariable int orderId) {
        orderService.cancelOrderById(orderId);
        return orderService.getAllOrders();
    }

}
