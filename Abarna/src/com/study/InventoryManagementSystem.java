package com.study;
import java.util.HashMap;
import java.util.Map;

// Product class
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: $" + price;
    }
}

// Inventory Management System class
public class InventoryManagementSystem {
    private Map<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Product ID already exists.");
        } else {
            inventory.put(product.productId, product);
            System.out.println("Product added: " + product);
        }
    }

    // Update an existing product
    public void updateProduct(int productId, String newName, int newQuantity, double newPrice) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.productName = newName;
            product.quantity = newQuantity;
            product.price = newPrice;
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product removed. ID: " + productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();

        // Adding products
        system.addProduct(new Product(101, "Laptop", 10, 1500.00));
        system.addProduct(new Product(102, "Mouse", 50, 25.99));
        system.addProduct(new Product(103, "Keyboard", 30, 45.50));

        // Display inventory
        system.displayInventory();

        // Update a product
        system.updateProduct(102, "Wireless Mouse", 40, 35.99);

        // Delete a product
        system.deleteProduct(101);

        // Final inventory display
        system.displayInventory();
    }
}


