package com.tss.Creational.Builder;

public class User {

    private final String name;
    private final int age;
    private final String city;
    private final String phone;
    private final boolean isAdmin;
    private final boolean isActive;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
        this.phone = builder.phone;
        this.isAdmin = builder.isAdmin;
        this.isActive = builder.isActive;
    }

    public static class Builder {

        // Required parameters
        private final String name;
        private final int age;

        // Optional parameters
        private String city;
        private String phone;
        private boolean isAdmin;
        private boolean isActive;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age +
                ", city='" + city + "', phone='" + phone +
                "', isAdmin=" + isAdmin +
                ", isActive=" + isActive + "}";
    }
}
