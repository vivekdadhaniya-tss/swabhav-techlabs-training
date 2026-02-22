package com.tss.ooad.chap01_ricks_guitars;

public class Guitar {

    private String serialNumber;
    private double price;
    private GuitarSpec guitarSpec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.guitarSpec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public GuitarSpec getGuitarSpec() {
        return guitarSpec;
    }

    @Override
    public String toString() {
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
                serialNumber,
                guitarSpec.getBuilder(),
                guitarSpec.getModel(),
                guitarSpec.getType(),
                guitarSpec.getBackWood(),
                guitarSpec.getTopWood(),
                guitarSpec.getNumStrings(),
                price
        );
    }
}