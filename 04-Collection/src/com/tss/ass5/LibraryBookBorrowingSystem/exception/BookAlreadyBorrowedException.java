package com.tss.ass5.LibraryBookBorrowingSystem.exception;

public class BookAlreadyBorrowedException extends RuntimeException {

    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}