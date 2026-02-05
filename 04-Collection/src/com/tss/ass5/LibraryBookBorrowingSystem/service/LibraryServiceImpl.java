package com.tss.ass5.LibraryBookBorrowingSystem.service;

import com.tss.ass5.LibraryBookBorrowingSystem.exception.*;
import com.tss.ass5.LibraryBookBorrowingSystem.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private final Library library;

    public LibraryServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(String isbn, String title, String author, Category category) {
        if(library.getBooksByIsbn().containsKey(isbn)) {
            throw new DuplicateIsbnException("Book with ISBN " + isbn + " already exists");
        }
        Book book = new Book(isbn, title, author, category);
        library.getBooksByIsbn().put(isbn, book);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = library.getBooksByIsbn().get(isbn);
        if(book == null) {
            throw new BookNotFoundException("Book not found with ISBN: " + isbn);
        }
        return book;
    }

    @Override
    public int addBookCopy(String isbn) {
        Book book = library.getBooksByIsbn().get(isbn);
        BookCopy bookCopy = new BookCopy(book);
        library.getBookCopies().put(bookCopy.getBookNumber(), bookCopy);
        return bookCopy.getBookNumber();
    }

    @Override
    public int getTotalCopiesByIsbn(String isbn) {
        int count = 0;
        for (BookCopy bookCopy : library.getBookCopies().values()) {
            if (bookCopy.getBook().getIsbn().equals(isbn)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAvailableCopiesByIsbn(String isbn) {
        int count = 0;
        for(BookCopy bookCopy : library.getBookCopies().values()) {
            if(bookCopy.getBook().getIsbn().equals(isbn)
                    && !isBookCopyBorrowed(bookCopy.getBookNumber())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void addMember(String name, String email) {
        if(library.getMembersByEmail().containsKey(email)) {
            throw new DuplicateEmailException("Member with email already exists");
        }
        Member member = new Member(name, email);
        library.getMembersByEmail().put(email, member);
    }

    @Override
    public Member getMemberByEmail(String email) {
        Member member = library.getMembersByEmail().get(email);
        if(member == null) {
            throw new MemberNotFoundException("Member not found with email: " + email);
        }
        return member;
    }

    @Override
    public void borrowBook(String memberEmail, int bookNumber) {
        Member member = getMemberByEmail(memberEmail);
        BookCopy bookCopy = library.getBookCopies().get(bookNumber);
        if(bookCopy == null)
            throw new BookNotFoundException(
                    "Book copy with number " + bookNumber + " does not exist in the library.");

        if(isBookCopyBorrowed(bookNumber))
            throw new BookAlreadyBorrowedException("Book copy already borrowed");

        String isbn = bookCopy.getBook().getIsbn();

        if(hasMemberBorrowedSameIsbn(member, isbn))
            throw new BookAlreadyBorrowedException(
                    "Member already borrowed a book with ISBN: " + isbn
            );

        library.getBorrowRecords().add(new BorrowRecord(bookCopy, member));

    }

    @Override
    public void returnBook(String memberEmail, int bookNumber) {
        for (BorrowRecord record : library.getBorrowRecords()) {
            if(record.getMember().getEmail().equals(memberEmail)
                && record.getBookCopy().getBookNumber() == bookNumber
                && record.getReturnDate() == null) {
                record.returnBook();
                return;
            }
        }
        throw new BookNotFoundException("Borrowed record not found");
    }

    @Override
    public boolean isBookCopyBorrowed(int bookNumber) {
        for (BorrowRecord record : library.getBorrowRecords()) {
            if (record.getBookCopy().getBookNumber() == bookNumber
                            && record.getReturnDate() == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasMemberBorrowedSameIsbn(Member member, String isbn) {
        for(BorrowRecord record : library.getBorrowRecords()) {
            if(record.getMember().equals(member)
                    && record.getReturnDate() == null
                    && record.getBookCopy().getBook().getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BorrowRecord> getBorrowedBooksByMember(String memberEmail) {
        Member member = getMemberByEmail(memberEmail);
        List<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : library.getBorrowRecords()) {
            if(record.getMember().equals(member)
                && record.getReturnDate() == null) {
                result.add(record);
            }
        }
        return result;
    }

    @Override
    public BorrowRecord getBorrowRecordByBookNumber(int bookNumber) {
        for (BorrowRecord record : library.getBorrowRecords()) {
            if(record.getBookCopy().getBookNumber() == bookNumber
                && record.getReturnDate() == null) {
                return record;
            }
        }
        return null;
    }

    @Override
    public List<BookCopy> getAllBookCopies() {
        return new ArrayList<>(library.getBookCopies().values());
    }

    @Override
    public Collection<Book> getAllBooks() {
        return library.getBooksByIsbn().values();
    }

    @Override
    public Collection<Member> getAllMembers() {
        return library.getMembersByEmail().values();
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return library.getBorrowRecords();
    }
    
}
