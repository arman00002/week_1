package InventoryManagementSystem;

import java.util.*;

public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    private static HashMap<String, Product> inventory = new HashMap<>();

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public static void addProduct(String id, String name, int qty, double price) {
        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists.");
        } else {
            Product p = new Product(id, name, qty, price);
            inventory.put(id, p);
            System.out.println("Product added: " + id);
        }
    }

    public static void updateProduct(String id, int newQty, double newPrice) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("Product updated: " + id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(String id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted: " + id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void showInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Product p : inventory.values()) {
            System.out.println("ID: " + p.productId + ", Name: " + p.productName +
                    ", Qty: " + p.quantity + ", Price: Rs." + p.price);
        }
    }

    public static void main(String[] args) {
        addProduct("P001", "Tablet", 20, 12000);
        addProduct("P002", "Monitor", 15, 8500);
        addProduct("P003", "Router", 30, 2100);

        showInventory();

        System.out.println("\nUpdating Monitor...");
        updateProduct("P002", 18, 8200);

        System.out.println("\nDeleting Router...");
        deleteProduct("P003");

        showInventory();
    }
}

