package com.tss.ooad.chap01_ricks_guitars;

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