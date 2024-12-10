package Guac.N.Roll.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "provider_orders";
    }

    @PostMapping("/update/{orderId}")
    public String updateOrderStatus(@PathVariable int orderId, @RequestParam("status") String status) {
        orderService.updateOrderStatus(orderId, status);
        return "redirect:/orders";
    }

    @PostMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable int orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }

    @PostMapping("/complete/{orderId}")
    public String markOrderAsCompleted(@PathVariable int orderId) {
        orderService.markOrderAsCompleted(orderId);
        return "redirect:/orders";
    }

    @GetMapping("/details/{orderId}")
    public String getOrderDetails(@PathVariable int orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order_details"; // Create a separate page for detailed order view
    }
}
