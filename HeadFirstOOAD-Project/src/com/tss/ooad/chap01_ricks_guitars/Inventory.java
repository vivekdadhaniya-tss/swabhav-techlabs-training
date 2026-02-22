package com.tss.ooad.chap01_ricks_guitars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {

    private final List<Guitar> guitars;

    public Inventory() {
        guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price,GuitarSpec guitarSpec) {
        Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for(Guitar guitar : guitars) {
            if(guitar.getSerialNumber().equals(serialNumber))   return guitar;
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {

        List<Guitar> matchingGuitars = new ArrayList<>();

        for (Guitar guitar : guitars) {
            GuitarSpec guitarSpec = guitar.getGuitarSpec();

            if (guitarSpec.matches(searchSpec))
                matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}