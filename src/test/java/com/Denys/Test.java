package com.Denys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ECommerceSystemTest {
    private Product product1;
    private Product product2;
    private Cart cart;
    private Order order;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Product 1", 30.0);
        product2 = new Product(2, "Product 2", 50.0);

        cart = mock(Cart.class);
        order = mock(Order.class);
        when(order.getStatus()).thenReturn("Pending");

        order = new Order(1, cart.getProducts());
    }

    @Test
    public void testAddProductToCart() {
        when(cart.getProducts()).thenReturn(Arrays.asList(product1, product2));
        cart.addProduct(product2);
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        when(cart.getProducts()).thenReturn(new ArrayList<>());
        cart.removeProduct(product1);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testCreateOrderFromCart() {
        when(cart.getProducts()).thenReturn(Arrays.asList(product1, product2));
        Order newOrder = new Order(2, cart.getProducts());
        assertEquals(cart.getProducts(), newOrder.getProducts());
    }

    @Test
    public void testGetOrderStatus() {
        assertEquals("Pending", order.getStatus());
    }
}