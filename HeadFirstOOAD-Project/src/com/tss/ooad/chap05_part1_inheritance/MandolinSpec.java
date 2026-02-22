package com.tss.ooad.chap05_part1_inheritance;

import com.tss.ooad.chap05_part1_inheritance.type.Builder;
import com.tss.ooad.chap05_part1_inheritance.type.Style;
import com.tss.ooad.chap05_part1_inheritance.type.Type;
import com.tss.ooad.chap05_part1_inheritance.type.Wood;

public class MandolinSpec extends InstrumentSpec {

    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Style style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) return false;

        if (!(otherSpec instanceof MandolinSpec)) return false;

        MandolinSpec mandolinSpec = (MandolinSpec)otherSpec;
        if (style != mandolinSpec.style) return false;
        return true;
    }
}
