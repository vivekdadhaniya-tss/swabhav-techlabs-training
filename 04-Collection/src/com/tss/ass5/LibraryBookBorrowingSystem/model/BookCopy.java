package com.tss.ass5.LibraryBookBorrowingSystem.model;

public class BookCopy {

    private static int bookCounter = 100000;
    private final int bookNumber;   // Unique per copy
    private final Book book;        // Same Book reference

    public BookCopy(Book book) {
        this.bookNumber = ++bookCounter;
        this.book = book;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public Book getBook() {
        return book;
    }
}
