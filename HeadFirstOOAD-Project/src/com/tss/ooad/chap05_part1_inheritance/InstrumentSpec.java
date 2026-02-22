package com.tss.ooad.chap05_part1_inheritance;

import com.tss.ooad.chap05_part1_inheritance.type.Builder;
import com.tss.ooad.chap05_part1_inheritance.type.Type;
import com.tss.ooad.chap05_part1_inheritance.type.Wood;

public abstract class InstrumentSpec {

    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    public InstrumentSpec(Builder builder, String model,
                          Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public boolean matches(InstrumentSpec otherSpec) {

        if (builder != otherSpec.builder) return false;

        if (model != null && !model.isBlank() &&
                !model.equalsIgnoreCase(otherSpec.model)) return false;

        if (type != otherSpec.type) return false;
        if (backWood != otherSpec.backWood) return false;
        if (topWood != otherSpec.topWood) return false;

        return true;
    }
}

