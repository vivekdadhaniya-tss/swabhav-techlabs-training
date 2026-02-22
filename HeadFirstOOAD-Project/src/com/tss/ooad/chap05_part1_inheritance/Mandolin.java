package com.tss.ooad.chap05_part1_inheritance;

public class Mandolin extends Instrument {

    public Mandolin(String serialNumber, double price, MandolinSpec spec) {
        super(serialNumber, price, spec);
    }

    @Override
    public MandolinSpec getSpec() {
        return (MandolinSpec) super.getSpec();
    }

    @Override
    public String toString() {

        MandolinSpec mandolinSpec = getSpec();

        return """
            Mandolin Details:
            ----------------
            Serial Number : %s
            Builder       : %s
            Model         : %s
            Type          : %s
            Style         : %s
            Back Wood     : %s
            Top Wood      : %s
            Strings       : %d
            Price         : $%.2f
            ----------------
            """.formatted(
                getSerialNumber(),
                mandolinSpec.getBuilder(),
                mandolinSpec.getModel(),
                mandolinSpec.getType(),
                mandolinSpec.getStyle(),
                mandolinSpec.getBackWood(),
                mandolinSpec.getTopWood(),
                getPrice()
        );
    }
}
