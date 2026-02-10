package com.tss.ass4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static List<Order> orders;

    public static void main(String[] args) {

        orders = List.of(
                new Order(101, "Aarav",   "Electronics", 2, 1500.0, OrderStatus.PENDING),
                new Order(102, "Vihaan",  "Clothing",    5, 500.0,  OrderStatus.DELIVERED),
                new Order(103, "Aarav",   "Electronics", 1, 2000.0, OrderStatus.SHIPPED),
                new Order(104, "Ishaan",  "Groceries",   10, 100.0, OrderStatus.DELIVERED),
                new Order(105, "Aarav",   "Clothing",    3, 700.0,  OrderStatus.DELIVERED),
                new Order(106, "Rohit",   "Electronics", 4, 1200.0, OrderStatus.SHIPPED),
                new Order(107, "Aarav",   "Books",       6, 300.0,  OrderStatus.DELIVERED)
        );

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1 -> printOrdersByCustomer();
                case 2 -> printDeliveredOrders();
                case 3 -> printUniqueProductCategories();
                case 4 -> printTotalRevenueShipped();
                case 5 -> printAverageQuantityByCategory();
                case 6 -> printOrderWithHighestValue();
                case 7 -> groupOrdersByStatus();
                case 8 -> printCustomersWithMoreThanTwoOrders();
                case 9 -> printOrdersSortedByTotalValue();
                case 10 -> checkClothingQuantityLessThanTen();
                case 0 -> System.out.println("Exiting the application...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while(choice != 0);
    }

    private static void printMenu() {
        System.out.println("""
            \n===== Order Management Menu =====
            1. Print all orders of a customer
            2. Print only Delivered orders
            3. List all product categories without duplicates
            4. Calculate total revenue of Shipped orders
            5. Find average quantity for a product category
            6. Find order with highest total value
            7. Group orders by status and count
            8. List customers with more than 2 orders
            9. Sort orders by total value (desc) and print top 3
           10. Check if all Clothing orders have quantity < 10
            0. Exit
           """);
    }

    private static void printOrdersByCustomer() {
        System.out.print("Enter customer name: ");
        String customerName = scan.nextLine().trim();
        System.out.println("Orders of " + customerName + ":");
        orders.stream()
                .filter(order -> order.getCustomerName().equalsIgnoreCase(customerName))
                .forEach(System.out::println);
    }

    private static void printDeliveredOrders() {
        System.out.println("Delivered Orders:");
        orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.DELIVERED)
                .forEach(System.out::println);
    }

    private static void printUniqueProductCategories() {
        System.out.println("All Product Categories (unique):");
        orders.stream()
                .map(Order::getProductCategory)
                .distinct()
                .forEach(System.out::println);
    }

    private static void printTotalRevenueShipped() {
        double totalRevenue = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.SHIPPED)
                .mapToDouble(order -> order.getQuantity() * order.getPricePerUnit())
                .sum();
        System.out.println("Total revenue of Shipped orders: " + totalRevenue);
    }

    private static void printAverageQuantityByCategory() {
        System.out.print("Enter product category: ");
        String category = scan.nextLine().trim();
        double avgQuantity = orders.stream()
                .filter(order -> order.getProductCategory().equalsIgnoreCase(category))
                .mapToInt(Order::getQuantity)
                .average()
                .orElse(0.0);
        System.out.println("Average quantity of " + category + " orders: " + avgQuantity);
    }

    private static void printOrderWithHighestValue() {
        orders.stream()
                .max(Comparator.comparingDouble(
                        order -> order.getQuantity() * order.getPricePerUnit()))
                .ifPresent(System.out::println);
    }

    private static void groupOrdersByStatus() {
        System.out.println("Orders grouped by status:");

        orders.stream()
                .collect(
                        Collectors.groupingBy(Order::getStatus,Collectors.counting())
                )
                .forEach((status, count) -> System.out.println(status + " : " + count));
    }

    private static void printCustomersWithMoreThanTwoOrders() {
        System.out.println("Customers with more than 2 orders:");
        orders.stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 2)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    private static void printOrdersSortedByTotalValue() {
        orders.stream()
                .sorted(Comparator.comparingDouble(
                        (Order order) -> order.getQuantity() * order.getPricePerUnit()
                ).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void checkClothingQuantityLessThanTen() {
        boolean result = orders.stream()
                .filter(order -> order.getProductCategory().equalsIgnoreCase("Clothing"))
                .allMatch(order -> order.getQuantity() < 10);

        System.out.println("All clothing orders have quantity < 10: " + result);
    }
}
