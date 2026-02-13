package com.tss.Creational.Builder;

public class BuilderDemo {

    public static void main(String[] args) {

        User user = new User.Builder("Aarav", 26)
                .city("New York")
                .phone("1234567890")
                .isAdmin(true)
                .isActive(true)
                .build();

        System.out.println(user);
    }
}
