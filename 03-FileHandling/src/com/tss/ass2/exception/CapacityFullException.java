package com.tss.ass2.exception;

public class CapacityFullException extends RuntimeException{
    private final int capacity;

    public CapacityFullException(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getMessage() {
        return "Capacity limit reached. Maximum allowed: " + capacity;
    }
}
