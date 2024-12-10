package Guac.N.Roll.Distributor;

import Guac.N.Roll.Product.Product;
import Guac.N.Roll.Product.ProductRepository;
import Guac.N.Roll.Order.Order;
import Guac.N.Roll.Order.OrderRepository;
import Guac.N.Roll.Driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/distributor")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @Autowired
    private ProductRepository productRepository;
    private OrderRepository orderRepository;


    // Show distributor dashboard
    @GetMapping("/home")
    public String showDistributorHomePage() {
        return "distributor_home";
    }

    // Show "Create Driver" page
    @GetMapping("/drivers/create")
    public String showCreateDriverPage() {
        return "create_driver";
    }

    // Manage drivers
    @GetMapping("/drivers/manage")
    public String manageDrivers(Model model) {
        List<Driver> drivers = distributorService.getAllDrivers();
        model.addAttribute("drivers", drivers);
        return "manage_drivers";
    }

    @PostMapping("/drivers/create")
    public String createDriver(
            @RequestParam String name,
            @RequestParam String licenseNumber,
            @RequestParam String email) {
        distributorService.createDriver(name, licenseNumber, email);
        return "redirect:/distributor/drivers/manage";
    }

    @PostMapping("/drivers/edit/{driverId}")
    public String editDriver(
            @PathVariable Long driverId,
            @RequestParam String name,
            @RequestParam String licenseNumber,
            @RequestParam String email) {
        distributorService.editDriver(driverId, name, licenseNumber, email);
        return "redirect:/distributor/drivers/manage";
    }

    @PostMapping("/drivers/delete/{driverId}")
    public String deleteDriver(@PathVariable Long driverId) {
        distributorService.deleteDriver(driverId);
        return "redirect:/distributor/drivers/manage";
    }

    // Restock products
    @GetMapping("/products/restock")
    public String showRestockProductsPage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "restock_products";
    }

    @PostMapping("/products/restock/{productId}")
    public String restockProduct(@PathVariable Long productId, @RequestParam int quantity) {
        distributorService.restockProduct(productId, quantity);
        return "redirect:/distributor/products/restock";
    }

    // Assign drivers to orders
    @GetMapping("/orders/assign")
    public String showAssignDriverPage(Model model) {
        model.addAttribute("drivers", distributorService.getAllDrivers());
        model.addAttribute("orders", distributorService.getAllOrders());
        return "assign_drivers";
    }

    @PostMapping("/orders/assign")
    public String assignDriverToOrder(
            @RequestParam Long driverId,
            @RequestParam int orderId) {
        distributorService.assignDriverToOrder(driverId, orderId);
        return "redirect:/distributor/orders/assign";
    }
    @GetMapping("/orders")
    public String getAllDeliveryOrders(Model model) {
        List<Order> deliveryOrders = orderRepository.findByOrderType("Delivery");
        model.addAttribute("orders", deliveryOrders);
        return "distributor_orders";
    }


}
