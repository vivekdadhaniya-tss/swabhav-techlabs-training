package com.tss.ass5.LibraryBookBorrowingSystem.service;

import com.tss.ass5.LibraryBookBorrowingSystem.model.*;

import java.util.Collection;
import java.util.List;

public interface LibraryService {

    void addBook(String isbn, String title, String author, Category category);
    Book getBookByIsbn(String isbn);

    int addBookCopy(String isbn);
    int getTotalCopiesByIsbn(String isbn);
    int getAvailableCopiesByIsbn(String isbn);

    void addMember(String name, String email);
    Member getMemberByEmail(String email);

    void borrowBook(String memberEmail, int bookNumber);
    void returnBook(String memberEmail, int bookNumber);

    boolean isBookCopyBorrowed(int bookNumber);
    boolean hasMemberBorrowedSameIsbn(Member member, String isbn);

    List<BorrowRecord> getBorrowedBooksByMember(String memberEmail);
    BorrowRecord getBorrowRecordByBookNumber(int bookNumber);

    Collection<Book> getAllBooks();
    Collection<Member> getAllMembers();
    List<BorrowRecord> getAllBorrowRecords();

    List<BookCopy> getAllBookCopies();
}
