package com.tss.ooad.chap05_part1_inheritance.type;

public enum Type {

    ACOUSTIC("Acoustic"),
    ELECTRIC("Electric");

    private final String displayName;

    Type(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}