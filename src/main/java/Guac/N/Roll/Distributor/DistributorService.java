package Guac.N.Roll.Distributor;

import Guac.N.Roll.Order.Order;
import Guac.N.Roll.Order.OrderRepository;
import Guac.N.Roll.Driver.Driver;
import Guac.N.Roll.Driver.DriverRepository;
import Guac.N.Roll.Product.Product;
import Guac.N.Roll.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Create a driver
    public Driver createDriver(String name, String licenseNumber, String email) {
        Driver driver = new Driver(name, licenseNumber, email, true);
        return driverRepository.save(driver);
    }

    // Edit a driver
    public boolean editDriver(Long driverId, String name, String licenseNumber, String email) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if (driverOptional.isPresent()) {
            Driver driver = driverOptional.get();
            driver.setName(name);
            driver.setLicenseNumber(licenseNumber);
            driver.setEmail(email);
            driverRepository.save(driver);
            return true;
        }
        return false;
    }

    // Delete a driver
    public boolean deleteDriver(Long driverId) {
        if (driverRepository.existsById(driverId)) {
            driverRepository.deleteById(driverId);
            return true;
        }
        return false;
    }

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Restock a product
    public boolean restockProduct(Long productId, int quantity) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setStock(product.getStock() + quantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    // Assign a driver to an order
    public boolean assignDriverToOrder(Long driverId, int orderId) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (driverOptional.isPresent() && orderOptional.isPresent()) {
            Driver driver = driverOptional.get();
            Order order = orderOptional.get();

            if (driver.isAvailable()) {
                driver.setAvailable(false); // Mark driver as unavailable
                order.setDetails(order.getDetails() + " | Driver Assigned: " + driver.getName());
                driverRepository.save(driver);
                orderRepository.save(order);
                return true;
            }
        }
        return false;
    }

}
