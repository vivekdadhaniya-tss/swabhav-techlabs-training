package com.tss.ass5.LibraryBookBorrowingSystem.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String message) {
        super(message);
    }
}