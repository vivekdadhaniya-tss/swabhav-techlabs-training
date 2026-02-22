package com.tss.ooad.chap05_part1_inheritance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {

    private final List<Instrument> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument instrument = null;
        if(instrumentSpec instanceof GuitarSpec guitarSpec) {
            instrument = new Guitar(serialNumber, price, guitarSpec);
        } else if (instrumentSpec instanceof MandolinSpec mandolinSpec) {
            instrument = new Mandolin(serialNumber, price, mandolinSpec);
        }
        inventory.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new ArrayList<>();

        for (Instrument instrument : inventory) {
            Guitar guitar = (Guitar) instrument;
            if (guitar.getSpec().matches(searchSpec))
                matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }

    public List<Mandolin> search(MandolinSpec searchSpec) {
        List<Mandolin> matchingMandolins = new ArrayList<>();

        for (Instrument instrument : inventory) {
            Mandolin mandolin = (Mandolin) instrument;
            if (mandolin.getSpec().matches(searchSpec))
                matchingMandolins.add(mandolin);
        }
        return matchingMandolins;
    }
}