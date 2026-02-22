package com.tss.ooad.chap05_part2_cohesive;

public class Instrument {

    private String serialNumber;
    private double price;
    private InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }

//    @Override
//    public String toString() {
//        return "----------------------------------\n" +
//                "Serial Number : " + serialNumber + "\n" +
//                spec.toString() +
//                "Price : $" + price + "\n" +
//                "----------------------------------";
//    }

    @Override
    public String toString() {

        return "----------------------------------\n" +
                String.format("%-18s : %s%n", "Serial Number", serialNumber) +
                spec.toString() +
                String.format("%-18s : $%.2f%n", "Price", price) +
                "----------------------------------";
    }
}

