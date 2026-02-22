package com.tss.ooad.chap01_ricks_guitars;

public enum Wood {

    INDIAN_ROSEWOOD("Indian Rosewood"),
    BRAZILIAN_ROSEWOOD("Brazilian Rosewood"),
    MAHOGANY("Mahogany"),
    MAPLE("Maple"),
    COCOBOLO("Cocobolo"),
    CEDAR("Cedar"),
    ADIRONDACK("Adirondack"),
    ALDER("Alder"),
    SITKA("Sitka");

    private final String displayName;

    Wood(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
