package com.tss.ass12;

class AgeException extends Exception {

    private int age;

    public AgeException(int age) {
        this.age = age;
    }

    @Override
    public String getMessage() {
        return "Age " + age + " is not allowed for voting. Minimum age is 18.";
    }
}

