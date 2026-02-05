package com.tss.ass5.LibraryBookBorrowingSystem.view;

import com.tss.ass5.LibraryBookBorrowingSystem.model.*;
import com.tss.ass5.LibraryBookBorrowingSystem.service.LibraryService;

import java.util.Collection;
import java.util.List;

public final class LibraryDisplay {

    private LibraryDisplay() {}

    public static void showAllBooks(Collection<Book> books, LibraryService service) {

        if (books.isEmpty()) {
            System.out.println("\n📚 No books available in the library.");
            return;
        }

        printAllBooksHeader();

        for (Book book : books) {

            int total = service.getTotalCopiesByIsbn(book.getIsbn());
            int available = service.getAvailableCopiesByIsbn(book.getIsbn());

            System.out.printf(
                    "║ %-20s │ %-25s │ %-20s │ %-15s │ %-7d │ %-9d ║%n",
                    book.getIsbn(),
                    truncate(book.getTitle(), 25),
                    truncate(book.getAuthor(), 20),
                    truncate(book.getCategory().name(), 15),
                    total,
                    available
            );
        }

        printAllBooksFooter();
    }

    private static void printAllBooksHeader() {
        System.out.println(
                "\n╔══════════════════════╤═══════════════════════════╤══════════════════════╤═════════════════╤═════════╤═══════════╗"
        );
        System.out.printf(
                "║ %-20s │ %-25s │ %-20s │ %-15s │ %-7s │ %-9s ║%n",
                "ISBN", "TITLE", "AUTHOR", "CATEGORY", "TOTAL", "AVAILABLE"
        );
        System.out.println(
                "╠══════════════════════╪═══════════════════════════╪══════════════════════╪═════════════════╪═════════╪═══════════╣"
        );
    }

    private static void printAllBooksFooter() {
        System.out.println(
                "╚══════════════════════╧═══════════════════════════╧══════════════════════╧═════════════════╧═════════╧═══════════╝"
        );
    }

    // =========================================================
    // ====================== ALL MEMBERS ======================
    // =========================================================

    public static void showAllMembers(Collection<Member> members) {

        if (members.isEmpty()) {
            System.out.println("\n👤 No members found.");
            return;
        }

        printMembersHeader();

        for (Member member : members) {
            System.out.printf(
                    "║ %-25s │ %-30s ║%n",
                    truncate(member.getName(), 25),
                    truncate(member.getEmail(), 30)
            );
        }

        printMembersFooter();
    }

    private static void printMembersHeader() {
        System.out.println(
                "\n╔═══════════════════════════╤════════════════════════════════╗"
        );
        System.out.printf(
                "║ %-25s │ %-30s ║%n",
                "NAME", "EMAIL"
        );
        System.out.println(
                "╠═══════════════════════════╪════════════════════════════════╣"
        );
    }

    private static void printMembersFooter() {
        System.out.println(
                "╚═══════════════════════════╧════════════════════════════════╝"
        );
    }

    // =========================================================
    // =============== BOOKS BORROWED BY MEMBER ================
    // =========================================================

    public static void showBooksBorrowedByMember(List<BorrowRecord> records) {

        if (records.isEmpty()) {
            System.out.println("\n📖 No books currently borrowed.");
            return;
        }

        printBorrowedByMemberHeader();

        for (BorrowRecord record : records) {
            System.out.printf(
                    "║ %-10d │ %-15s │ %-25s │ %-12s │ %-12s ║%n",
                    record.getBookCopy().getBookNumber(),
                    record.getBookCopy().getBook().getIsbn(),
                    truncate(record.getBookCopy().getBook().getTitle(), 25),
                    record.getBorrowDate(),
                    record.getReturnDate() == null ? "NOT RETURNED" : record.getReturnDate()
            );
        }

        printBorrowedByMemberFooter();
    }

    private static void printBorrowedByMemberHeader() {
        System.out.println(
                "\n╔════════════╤═════════════════╤═════════════════════════╤══════════════╤══════════════╗"
        );
        System.out.printf(
                "║ %-10s │ %-15s │ %-25s │ %-12s │ %-12s ║%n",
                "BOOK NO", "ISBN", "TITLE", "BORROW DATE", "RETURN DATE"
        );
        System.out.println(
                "╠════════════╪═════════════════╪═════════════════════════╪══════════════╪══════════════╣"
        );
    }

    private static void printBorrowedByMemberFooter() {
        System.out.println(
                "╚════════════╧═════════════════╧═════════════════════════╧══════════════╧══════════════╝"
        );
    }

    // =========================================================
    // ================= ALL BORROWED BOOKS ====================
    // =========================================================

    public static void showBorrowedBooks(List<BorrowRecord> records) {

        if (records.isEmpty()) {
            System.out.println("\n📚 No borrow records found.");
            return;
        }

        printBorrowedBooksHeader();

        boolean hasData = false;

        for (BorrowRecord record : records) {

            hasData = true;

            String returnDate =
                    record.getReturnDate() == null
                            ? "NOT RETURNED"
                            : record.getReturnDate().toString();

            System.out.printf(
                    "║ %-10d │ %-15s │ %-25s │ %-30s │ %-12s │ %-12s ║%n",
                    record.getBookCopy().getBookNumber(),
                    record.getBookCopy().getBook().getIsbn(),
                    truncate(record.getBookCopy().getBook().getTitle(), 25),
                    truncate(record.getMember().getEmail(), 30),
                    record.getBorrowDate(),
                    returnDate
            );
        }

        if (!hasData) {
            System.out.printf(
                    "║ %-104s ║%n",
                    "No borrowed books found"
            );
        }

        printBorrowedBooksFooter();
    }

    private static void printBorrowedBooksHeader() {
        System.out.println(
                "\n╔════════════╤═════════════════╤═════════════════════════╤════════════════════════════════╤══════════════╤══════════════╗"
        );
        System.out.printf(
                "║ %-10s │ %-15s │ %-25s │ %-30s │ %-12s │ %-12s ║%n",
                "BOOK NO",
                "ISBN",
                "TITLE",
                "MEMBER EMAIL",
                "BORROW DATE",
                "RETURN DATE"
        );
        System.out.println(
                "╠════════════╪═════════════════╪═════════════════════════╪════════════════════════════════╪══════════════╪══════════════╣"
        );
    }

    private static void printBorrowedBooksFooter() {
        System.out.println(
                "╚════════════╧═════════════════╧═════════════════════════╧════════════════════════════════╧══════════════╧══════════════╝"
        );
    }

    // =========================================================
    // ======================= UTILITIES =======================
    // =========================================================

    private static String truncate(String value, int maxLength) {
        if (value == null) return "";
        return value.length() <= maxLength
                ? value
                : value.substring(0, maxLength - 3) + "...";
    }

    // ================= BORROWER INFO =================

    public static void showBorrowerInfo(BorrowRecord record) {

        System.out.println("\n======================= BOOK BORROW STATUS =======================");

        if (record == null) {
            System.out.println("Status : AVAILABLE");
            return;
        }

        System.out.println("Status        : BORROWED");
        System.out.println("Member Email  : " + record.getMember().getEmail());
        System.out.println("Borrow Date   : " + record.getBorrowDate());
    }

    // =========================================================
    // ======================= BOOK COPIES =====================
    // =========================================================

    public static void showAvailableBookCopies(
            List<BookCopy> copies,
            LibraryService service
    ) {

        if (copies.isEmpty()) {
            System.out.println("\n📚 No book copies available.");
            return;
        }

        printBookCopiesHeader();

        for (BookCopy copy : copies) {

            boolean borrowed =
                    service.isBookCopyBorrowed(copy.getBookNumber());

            System.out.printf(
                    "║ %-10d │ %-15s │ %-20s │ %-15s │ %-12s ║%n",
                    copy.getBookNumber(),
                    copy.getBook().getIsbn(),
                    truncate(copy.getBook().getTitle(), 20),
                    truncate(copy.getBook().getCategory().name(), 15),
                    borrowed ? "BORROWED" : "AVAILABLE"
            );
        }

        printBookCopiesFooter();
    }

    private static void printBookCopiesHeader() {
        System.out.println(
                "\n╔════════════╤═════════════════╤══════════════════════╤═════════════════╤══════════════╗"
        );
        System.out.printf(
                "║ %-10s │ %-15s │ %-20s │ %-15s │ %-12s ║%n",
                "BOOK NO", "ISBN", "TITLE", "CATEGORY", "STATUS"
        );
        System.out.println(
                "╠════════════╪═════════════════╪══════════════════════╪═════════════════╪══════════════╣"
        );
    }

    private static void printBookCopiesFooter() {
        System.out.println(
                "╚════════════╧═════════════════╧══════════════════════╧═════════════════╧══════════════╝"
        );
    }

    // ================= BORROW HISTORY =================

    public static void showAllBorrowRecords(List<BorrowRecord> records) {

        if (records.isEmpty()) {
            System.out.println("\n📚 No borrow history available.");
            return;
        }

        printBorrowHistoryHeader();

        for (BorrowRecord record : records) {

            String returnDate =
                    record.getReturnDate() == null
                            ? "NOT RETURNED"
                            : record.getReturnDate().toString();

            System.out.printf(
                    "║ %-10d │ %-15s │ %-25s │ %-30s │ %-12s │ %-12s ║%n",
                    record.getBookCopy().getBookNumber(),
                    record.getBookCopy().getBook().getIsbn(),
                    truncate(record.getBookCopy().getBook().getTitle(), 25),
                    truncate(record.getMember().getEmail(), 30),
                    record.getBorrowDate(),
                    returnDate
            );
        }

        printBorrowHistoryFooter();
    }

    private static void printBorrowHistoryHeader() {
        System.out.println(
                "\n╔════════════╤═════════════════╤═════════════════════════╤════════════════════════════════╤══════════════╤══════════════╗"
        );
        System.out.printf(
                "║ %-10s │ %-15s │ %-25s │ %-30s │ %-12s │ %-12s ║%n",
                "BOOK NO",
                "ISBN",
                "TITLE",
                "MEMBER EMAIL",
                "BORROW DATE",
                "RETURN DATE"
        );
        System.out.println(
                "╠════════════╪═════════════════╪═════════════════════════╪════════════════════════════════╪══════════════╪══════════════╣"
        );
    }

    private static void printBorrowHistoryFooter() {
        System.out.println(
                "╚════════════╧═════════════════╧═════════════════════════╧════════════════════════════════╧══════════════╧══════════════╝"
        );
    }


}
