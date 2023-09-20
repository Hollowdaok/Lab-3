package org.example;
import java.util.List;

public class Order {
    private final int orderId;
    private final List<Product> products;
    private final String status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }


}
