package com.cognizant.inventory;

import java.util.HashMap;

public class InventoryManagement {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully.");
    }

    // Update Product
    public void updateProduct(int id, int quantity, double price) {

        Product product = inventory.get(id);

        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        if (inventory.remove(id) != null) {
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    // Display Products
    public void displayProducts() {

        System.out.println("\nInventory:");

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        InventoryManagement obj = new InventoryManagement();

        Product p1 = new Product(101, "Laptop", 20, 55000);
        Product p2 = new Product(102, "Mouse", 100, 500);
        Product p3 = new Product(103, "Keyboard", 50, 1200);

        obj.addProduct(p1);
        obj.addProduct(p2);
        obj.addProduct(p3);

        obj.displayProducts();

        obj.updateProduct(102, 120, 550);

        obj.displayProducts();

        obj.deleteProduct(101);

        obj.displayProducts();
    }
}