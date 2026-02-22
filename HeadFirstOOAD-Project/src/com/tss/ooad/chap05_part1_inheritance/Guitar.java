package com.tss.ooad.chap05_part1_inheritance;

public class Guitar extends Instrument {

    public Guitar(String serialNumber, double price, GuitarSpec guitarSpec) {
        super(serialNumber, price, guitarSpec);
    }

    @Override
    public GuitarSpec getSpec() {
        return (GuitarSpec) super.getSpec();
    }

    @Override
    public String toString() {

        GuitarSpec spec = getSpec();

        return """
            Guitar Details:
            ----------------
            Serial Number : %s
            Builder       : %s
            Model         : %s
            Type          : %s
            Back Wood     : %s
            Top Wood      : %s
            Strings       : %d
            Price         : $%.2f
            ----------------
            """.formatted(
                getSerialNumber(),
                spec.getBuilder(),
                spec.getModel(),
                spec.getType(),
                spec.getBackWood(),
                spec.getTopWood(),
                spec.getNumString(),
                getPrice()
        );
    }
}
