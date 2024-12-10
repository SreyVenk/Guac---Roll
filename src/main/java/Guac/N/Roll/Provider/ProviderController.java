package Guac.N.Roll.Provider;

import Guac.N.Roll.Order.Order;
import Guac.N.Roll.Order.OrderRepository;
import Guac.N.Roll.Product.Product;
import Guac.N.Roll.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/home")
    public String providerHome(Model model) {
        model.addAttribute("providerName", "Provider");
        return "provider_home";
    }

    @GetMapping("/orders")
    public String getAllPickupOrders(Model model) {
        List<Order> pickupOrders = orderRepository.findByOrderType("Pickup");
        model.addAttribute("orders", pickupOrders);
        return "provider_orders";
    }

    @GetMapping("/manage")
    public String manageProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "manage_products";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam String description,
                             @RequestParam double price, @RequestParam String imageUrl,
                             @RequestParam int stock) {
        Product product = new Product(name, description, price, imageUrl, stock);
        productRepository.save(product);
        return "redirect:/provider/manage";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/provider/manage";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @RequestParam String name,
                              @RequestParam String description, @RequestParam double price,
                              @RequestParam String imageUrl, @RequestParam int stock) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setImageUrl(imageUrl);
            product.setStock(stock);
            productRepository.save(product);
        }
        return "redirect:/provider/manage";
    }
}
