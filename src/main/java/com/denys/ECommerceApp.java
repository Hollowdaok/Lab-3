package com.denys;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        List<Order> orders = new ArrayList<>();
        int orderIdCounter = 1;

        while (true) {
            System.out.println("Welcome!");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Place Order");
            System.out.println("4. Check Order status");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int productId;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            productId = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid product ID. Please enter a number.");
                            scanner.next();
                        }
                    }

                    System.out.print("Enter Product Name: ");
                    String productName = scanner.next();
                    while (productName.isEmpty()) {
                        System.out.println("Product name cannot be empty. Please enter a valid name.");
                        productName = scanner.next();
                    }

                    double productPrice;
                    while (true) {
                        System.out.print("Enter Product Price: ");
                        if (scanner.hasNextDouble()) {
                            productPrice = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid product price. Please enter a valid number.");
                            scanner.next();
                        }
                    }

                    Product product = new Product(productId, productName, productPrice);
                    cart.addProduct(product);
                    System.out.println(productName + " added to cart.");
                }
                case 2 -> {
                    System.out.print("Enter Product ID to remove: ");
                    int productIdToRemove;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            productIdToRemove = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid product ID. Please enter a number.");
                            scanner.next();
                        }
                    }

                    List<Product> productsInCart = cart.getProducts();
                    Product productToRemove = null;
                    for (Product p : productsInCart) {
                        if (p.getId() == productIdToRemove) {
                            productToRemove = p;
                            break;
                        }
                    }

                    if (productToRemove != null) {
                        cart.getProducts().removeIf(p -> p.getId() == productIdToRemove);
                        System.out.println("Product removed from cart.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                }
                case 3 -> {
                    if (!cart.getProducts().isEmpty()) {
                        Order order = new Order(orderIdCounter++, new ArrayList<>(cart.getProducts()));
                        orders.add(order);
                        cart.getProducts().clear();
                        System.out.println("Order placed.");
                    } else {
                        System.out.println("The cart is empty. Please add products to the cart before placing an order.");
                    }
                }
                case 4 -> {
                    System.out.println("Enter the order number:");
                    int orderIdToCheck = scanner.nextInt();
                    Order foundOrder = null;
                    for (Order o : orders) {
                        if (o.getOrderId() == orderIdToCheck) {
                            foundOrder = o;
                            break;
                        }
                    }
                    if (foundOrder != null) {
                        System.out.println("Order status " + foundOrder.getOrderId() + ": " + foundOrder.getStatus());
                    } else {
                        System.out.println("Order with number " + orderIdToCheck + " not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Thank you for using the e-commerce system.");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice. Please enter a correct option.");
            }
        }
    }
}