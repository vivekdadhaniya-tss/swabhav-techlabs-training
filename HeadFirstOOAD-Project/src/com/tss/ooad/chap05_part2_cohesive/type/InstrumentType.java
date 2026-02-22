package com.tss.ooad.chap05_part2_cohesive.type;

public enum InstrumentType {
    GUITAR("Guitar"),
    BANJO("Banjo"),
    MANDOLIN("Mandolin"),
    FIDDLE("Fiddle"),
    BASS("Bass"),
    DOBRO("Dobro");

    private final String displayName;

    InstrumentType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
