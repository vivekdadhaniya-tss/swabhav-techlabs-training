package com.tss.ass5.LibraryBookBorrowingSystem.model;

import java.util.*;

public class Library {

    private final Map<String, Book> booksByIsbn;        // ISBN unique
    private final Map<Integer, BookCopy> bookCopies;   // bookNumber unique
    private final Map<String, Member> membersByEmail;  // email unique
    private final List<BorrowRecord> borrowRecords;

    public Library() {
        this.booksByIsbn = new HashMap<>();
        this.bookCopies = new HashMap<>();
        this.membersByEmail = new HashMap<>();
        this.borrowRecords = new ArrayList<>();
    }

    public Map<String, Book> getBooksByIsbn() {
        return booksByIsbn;
    }

    public Map<Integer, BookCopy> getBookCopies() {
        return bookCopies;
    }

    public Map<String, Member> getMembersByEmail() {
        return membersByEmail;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }
}