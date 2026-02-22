package com.tss.ooad.chap05_part1_inheritance.type;

public enum Style {

    A("A"),
    F("F");

    private final String displayName;

    Style(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
