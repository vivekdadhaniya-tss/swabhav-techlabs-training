package com.tss.ass5.LibraryBookBorrowingSystem.model;

public class Book {

    private static int idCounter = 100;
    private final int bookId;
    private final String isbn;     // Same for all copies
    private final String title;
    private final String author;
    private final Category category;

    public Book(String isbn, String title, String author, Category category) {
        this.bookId = ++idCounter;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}
