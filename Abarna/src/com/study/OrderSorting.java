package com.study;
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer: " + customerName +
               ", Total Price: $" + totalPrice;
    }
}

public class OrderSorting {

    // Bubble Sort to sort orders by totalPrice
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stop if already sorted
        }
    }

    // Quick Sort to sort orders by totalPrice
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap pivot
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Utility method to print array of orders
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println(); // Blank line after output
    }

    // Main method to demonstrate sorting
    public static void main(String[] args) {
        // Sample data
        Order[] orders = {
            new Order(101, "Alice", 299.99),
            new Order(102, "Bob", 129.50),
            new Order(103, "Charlie", 550.75),
            new Order(104, "David", 210.00),
            new Order(105, "Eve", 420.20)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        Order[] bubbleSortedOrders = orders.clone();
        bubbleSort(bubbleSortedOrders);
        System.out.println("Orders Sorted by Bubble Sort (by Total Price):");
        printOrders(bubbleSortedOrders);

        // Quick Sort
        Order[] quickSortedOrders = orders.clone();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Orders Sorted by Quick Sort (by Total Price):");
        printOrders(quickSortedOrders);
    }
}



