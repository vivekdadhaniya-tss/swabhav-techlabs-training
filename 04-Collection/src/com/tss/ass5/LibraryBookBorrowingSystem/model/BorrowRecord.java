package com.tss.ass5.LibraryBookBorrowingSystem.model;

import java.time.LocalDate;

public class BorrowRecord {

    private final BookCopy bookCopy;
    private final Member member;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(BookCopy bookCopy, Member member) {
        this.bookCopy = bookCopy;
        this.member = member;
        this.borrowDate = LocalDate.now();
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
