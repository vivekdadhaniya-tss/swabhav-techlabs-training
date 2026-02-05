package com.tss.ass5.LibraryBookBorrowingSystem.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}