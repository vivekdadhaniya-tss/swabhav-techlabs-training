package com.tss.ooad.chap05_part1_inheritance;

import com.tss.ooad.chap05_part1_inheritance.type.Builder;
import com.tss.ooad.chap05_part1_inheritance.type.Type;
import com.tss.ooad.chap05_part1_inheritance.type.Wood;

public class GuitarSpec extends InstrumentSpec {

    private int numString;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numString) {
        super(builder, model, type, backWood, topWood);
        this.numString = numString;
    }

    public int getNumString() {
        return numString;
    }

    @Override
    public boolean matches(InstrumentSpec other) {
        if(!(super.matches(other))) return false;

        if (!(other instanceof GuitarSpec)) return false;

        if (numString != ((GuitarSpec)other).numString) return false;
        return true;
    }
}
