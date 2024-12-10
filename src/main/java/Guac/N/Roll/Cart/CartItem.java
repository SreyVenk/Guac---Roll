package Guac.N.Roll.Cart;

import Guac.N.Roll.Product.Product;

public class CartItem {

    private Product product; // The product being added to the cart
    private int quantity;    // Quantity of the product

    // Default Constructor
    public CartItem() {}

    // Parameterized Constructor
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Additional Method to Calculate Total Price
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
