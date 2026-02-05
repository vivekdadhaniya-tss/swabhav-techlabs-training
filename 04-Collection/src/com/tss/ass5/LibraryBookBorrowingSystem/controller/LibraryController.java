package com.tss.ass5.LibraryBookBorrowingSystem.controller;

import com.tss.ass5.LibraryBookBorrowingSystem.exception.BookNotFoundException;
import com.tss.ass5.LibraryBookBorrowingSystem.exception.MemberNotFoundException;
import com.tss.ass5.LibraryBookBorrowingSystem.model.BorrowRecord;
import com.tss.ass5.LibraryBookBorrowingSystem.model.Category;
import com.tss.ass5.LibraryBookBorrowingSystem.service.LibraryService;
import com.tss.ass5.LibraryBookBorrowingSystem.validation.InputValidator;
import com.tss.ass5.LibraryBookBorrowingSystem.view.LibraryDisplay;

import java.util.List;
import java.util.Scanner;

public class LibraryController {
    private final LibraryService libraryService;
    private final Scanner scan = new Scanner(System.in);

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void showMenu() {
        System.out.print("""
                
                ====================================
                    LIBRARY MANAGEMENT SYSTEM
                ====================================
                  1. Register Book (Title / ISBN)
                  2. Add Book Copy
                  3. Register Member
                  4. Borrow Book Copy
                  5. Return Book Copy
                  6. Show Book Copies by ISBN
                  7. Show All Books
                  8. Show All Members
                  9. Show Borrowed Books
                 10. View Books Borrowed By Member
                 11. Check Who Borrowed Book Copy
                 12. Show Borrow History
                  0. Exit
                ====================================
                """);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = InputValidator.readInt(scan, "Enter your choice: ");
            scan.nextLine();
            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addBookCopy();
                    case 3 -> addMember();
                    case 4 -> borrowBook();
                    case 5 -> returnBook();
                    case 6 -> showBooksByISBN();
                    case 7 -> showAllBooks();
                    case 8 -> showAllMembers();
                    case 9 -> showBorrowedBooks();
                    case 10 -> viewBooksBorrowedByMember();
                    case 11 -> checkWhoBorrowedBookCopy();
                    case 12 -> showBorrowHistory();
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private boolean hasBooks() {
        return !libraryService.getAllBooks().isEmpty();
    }

    private boolean hasMembers() {
        return !libraryService.getAllMembers().isEmpty();
    }

    private boolean hasBorrowedBooks() {
        return libraryService.getAllBorrowRecords()
                .stream()
                .anyMatch(r -> r.getReturnDate() == null);
    }

    public void addBook() {
        System.out.println("Add book details: ");
        String isbn = InputValidator.readValidIsbn(scan, "ISBN: ");
        String title = InputValidator.readNonEmptyString(scan, "Title: ");
        String author = InputValidator.readValidName(scan, "Author: ");
        Category category = InputValidator.readEnum(
                scan,
                "Select Book Category: ",
                Category.class
        );
        libraryService.addBook(isbn, title, author, category);
        System.out.println("Book added successfully");
    }

    public void addBookCopy() {
        if (!hasBooks())
            throw new BookNotFoundException("No books available. Please add a book first.");

        showAllBooks();
        System.out.println("Select ISBN from the above list.");
        String isbn = InputValidator.readValidIsbn(scan, "Enter ISBN: ");
        libraryService.addBookCopy(isbn);
        System.out.println("Book copy added successfully");
    }

    public void addMember() {
        String name = InputValidator.readValidName(scan, "Name");
        String email = InputValidator.readValidEmail(scan, "Email");

        libraryService.addMember(name, email);
        System.out.println("Member added successfully");

    }

    public void borrowBook() {
        if (!hasMembers())
            throw new MemberNotFoundException("No members found. Please add a member first.");

        if (!hasBooks())
            throw new BookNotFoundException("No books available. Please add a book first.");

        showAvailableBookCopies();
        String email = InputValidator.readValidEmail(scan, "Member Email");
        int bookNumber = InputValidator.readInt(scan, "Book Number: ");

        libraryService.borrowBook(email, bookNumber);
        System.out.println("Book borrowed successfully");
    }

    public void returnBook() {
        if (!hasBorrowedBooks())
            throw new BookNotFoundException("No borrowed books.");

        showAvailableBookCopies();
        String email = InputValidator.readValidEmail(scan, "Member Email");
        int bookNumber = InputValidator.readInt(scan, "Book Number: ");

        libraryService.returnBook(email, bookNumber);
        System.out.println("Book return successfully");
    }

    public void showBooksByISBN() {
        if (!hasBooks())
            throw new BookNotFoundException("No books available. Please add a book first.");

        String isbn = InputValidator.readValidIsbn(scan, "ISBN");

        int total = libraryService.getTotalCopiesByIsbn(isbn);
        int available = libraryService.getAvailableCopiesByIsbn(isbn);

        System.out.println("Total copies: " + total);
        System.out.println("Available copies: " + available);
    }

    public void viewBooksBorrowedByMember() {
        if (!hasBorrowedBooks())
            throw new BookNotFoundException("No borrowed books.");

        String email = InputValidator.readValidEmail(scan, "Member Email");
        List<BorrowRecord> records =
                libraryService.getBorrowedBooksByMember(email);

        LibraryDisplay.showBooksBorrowedByMember(records);
    }

    public void checkWhoBorrowedBookCopy() {
        if (!hasBorrowedBooks())
            throw new BookNotFoundException("No borrowed books.");

        int bookNumber = InputValidator.readInt(scan, "Book Number: ");
        BorrowRecord record =
                libraryService.getBorrowRecordByBookNumber(bookNumber);

        LibraryDisplay.showBorrowerInfo(record);
    }

    public void showAllBooks() {
        if (!hasBooks())
            throw new BookNotFoundException("No books available. Please add a book first.");

        LibraryDisplay.showAllBooks(
                libraryService.getAllBooks(),
                libraryService
        );
    }

    public void showAllMembers() {
        if (!hasMembers())
            throw new MemberNotFoundException("No members found. Please add a member first.");

        LibraryDisplay.showAllMembers(
                libraryService.getAllMembers()
        );
    }

    public void showBorrowedBooks() {
        if (!hasBorrowedBooks())
            throw new BookNotFoundException("No borrowed books.");

        LibraryDisplay.showBorrowedBooks(
                libraryService.getAllBorrowRecords()
        );
    }

    public void showAvailableBookCopies() {
        if (!hasBooks())
            throw new BookNotFoundException("No books available.");

        LibraryDisplay.showAvailableBookCopies(
                libraryService.getAllBookCopies(), libraryService
        );
    }

    public void showBorrowHistory() {
        LibraryDisplay.showAllBorrowRecords(
                libraryService.getAllBorrowRecords()
        );
    }

}
