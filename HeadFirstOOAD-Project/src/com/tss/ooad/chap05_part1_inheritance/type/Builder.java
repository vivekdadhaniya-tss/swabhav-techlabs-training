package com.tss.ooad.chap05_part1_inheritance.type;

public enum Builder {

    FENDER("Fender"),
    MARTIN("Martin"),
    GIBSON("Gibson"),
    COLLINGS("Collings"),
    OLSON("Olson"),
    RYAN("Ryan"),
    PRS("PRS"),
    ANY("Any");

    private final String displayName;

    Builder(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}