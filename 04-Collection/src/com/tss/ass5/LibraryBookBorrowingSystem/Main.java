package com.tss.ass5.LibraryBookBorrowingSystem;

import com.tss.ass5.LibraryBookBorrowingSystem.controller.LibraryController;
import com.tss.ass5.LibraryBookBorrowingSystem.model.Library;
import com.tss.ass5.LibraryBookBorrowingSystem.service.LibraryServiceImpl;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl(library);
        LibraryController libraryController = new LibraryController(libraryServiceImpl);

        libraryController.start();
    }
}
