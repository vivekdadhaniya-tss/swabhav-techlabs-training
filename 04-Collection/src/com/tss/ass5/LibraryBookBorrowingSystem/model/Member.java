package com.tss.ass5.LibraryBookBorrowingSystem.model;

public class Member {

    private static int idCounter = 100;

    private final int memberId;
    private final String name;
    private final String email;

    public Member(String name, String email) {
        this.memberId = idCounter++;
        this.name = name;
        this.email = email;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
