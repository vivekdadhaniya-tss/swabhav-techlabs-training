package com.tss.ass5.LibraryBookBorrowingSystem.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String message) {
        super(message);
    }
}