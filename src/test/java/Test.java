import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ECommerceSystemTest {
    private Product product1;
    private Product product2;
    private Cart cart;
    private Order order;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Product 1", 30.0);
        product2 = new Product(2, "Product 2", 50.0);
        cart = new Cart();
        cart.addProduct(product1);
        order = new Order(1, cart.getProducts());
    }

    @Test
    public void testAddProductToCart() {
        cart.addProduct(product2);
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        cart.removeProduct(product1);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testCreateOrderFromCart() {
        Order newOrder = new Order(2, cart.getProducts());
        assertEquals(cart.getProducts(), newOrder.getProducts());
    }

    @Test
    public void testGetOrderStatus() {
        assertEquals("Pending", order.getStatus());
    }
}
