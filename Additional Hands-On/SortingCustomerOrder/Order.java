package SortingCustomerOrder;

import java.util.*;

public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    private static Order[] orderList;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void display() {
        System.out.println("OrderID: " + orderId + ", Customer: " + customerName + ", Price: Rs." + totalPrice);
    }

    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] arr) {
        for (Order o : arr) {
            o.display();
        }
    }

    public static void main(String[] args) {
        orderList = new Order[] {
            new Order("O101", "Alice", 4999.0),
            new Order("O102", "Bob", 2599.5),
            new Order("O103", "Charlie", 8999.0),
            new Order("O104", "Diana", 3000.0)
        };

        System.out.println("Original Orders:");
        printOrders(orderList);

        bubbleSort(orderList);
        System.out.println("\nSorted by Bubble Sort:");
        printOrders(orderList);

        orderList = new Order[] {
            new Order("O101", "Alice", 4999.0),
            new Order("O102", "Bob", 2599.5),
            new Order("O103", "Charlie", 8999.0),
            new Order("O104", "Diana", 3000.0)
        };

        quickSort(orderList, 0, orderList.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        printOrders(orderList);
    }
}

