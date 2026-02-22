package com.tss.ooad.chap05_part2_cohesive;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Instrument> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument instrument = new Instrument(serialNumber, price, instrumentSpec);
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

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstruments = new ArrayList<>();
        if (searchSpec == null) {
            return matchingInstruments;
        }
        for (Instrument instrument : inventory) {
            if(instrument.getSpec().matches(searchSpec)) {
                matchingInstruments.add(instrument);
            }
        }
        return matchingInstruments;
    }
}