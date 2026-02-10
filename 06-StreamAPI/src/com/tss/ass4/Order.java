package com.tss.ass4;

public class Order {

    private int orderId;
    private String customerName;
    private String productCategory;
    private int quantity;
    private double pricePerUnit;
    private OrderStatus status;  // Pending, Shipped, Delivered

    public Order(int orderId, String customerName, String productCategory, int quantity, double pricePerUnit, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", status='" + status + '\'' +
                '}';
    }
}
