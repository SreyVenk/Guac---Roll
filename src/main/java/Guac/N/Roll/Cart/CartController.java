package Guac.N.Roll.Cart;

import Guac.N.Roll.Product.Product;
import Guac.N.Roll.Product.ProductService;
import Guac.N.Roll.Order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final OrderService orderService;

    public CartController(CartService cartService, ProductService productService, OrderService orderService) {
        this.cartService = cartService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
        Product product = productService.getProductById(productId);
        cartService.addToCart(product, quantity, session);
        return "redirect:/cart";
    }
    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
        cartService.updateQuantity(productId, quantity, session);
        return "redirect:/cart";
    }
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long productId, HttpSession session) {
        cartService.removeFromCart(productId, session);
        return "redirect:/cart";
    }
    @GetMapping
    public String showCart(Model model, HttpSession session) {
        model.addAttribute("cart", cartService.getCart(session));
        model.addAttribute("cartTotal", cartService.calculateCartTotal(session));
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkoutCart(
            @RequestParam String customerName,
            @RequestParam String orderType,
            @RequestParam(required = false) String deliveryAddress,
            HttpSession session,
            Model model) {

        List<CartItem> cart = cartService.getCart(session);
        if (cart.isEmpty()) {
            model.addAttribute("error", "Your cart is empty.");
            return "cart";
        }


        if ("Delivery".equalsIgnoreCase(orderType) && (deliveryAddress == null || deliveryAddress.isBlank())) {
            model.addAttribute("error", "Delivery address is required for delivery orders.");
            return "cart";
        }


        orderService.createOrder(customerName, orderType, deliveryAddress, cart);


        session.removeAttribute("cart");

        model.addAttribute("message", "Order placed successfully!");
        return "order_confirmation";
    }

}
