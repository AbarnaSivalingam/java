package com.study;
import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    // Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (products must be sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Helper: Sort products by productId
    public static void sortProductsById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
    }

    // Main method for testing
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Shirt", "Clothing"),
            new Product(2, "Book", "Education")
        };

        int targetId = 2;

        // Linear Search (no need to sort)
        Product resultLinear = linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Product not found"));

        // Binary Search (sort first)
        sortProductsById(products);
        Product resultBinary = binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Product not found"));
    }
}





