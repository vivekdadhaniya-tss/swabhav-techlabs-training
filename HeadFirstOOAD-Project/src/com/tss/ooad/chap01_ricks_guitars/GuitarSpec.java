package com.tss.ooad.chap01_ricks_guitars;

public class GuitarSpec {

    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numStrings) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {

        if (otherSpec.getModel() != null &&
                !otherSpec.getModel().isBlank()) {

            if (this.model == null ||
                    !this.model.equalsIgnoreCase(otherSpec.getModel()))
                return false;
        }

        if (otherSpec.getBuilder() != this.builder)
            return false;

        if (otherSpec.getType() != this.type)
            return false;

        if (otherSpec.getBackWood() != this.backWood)
            return false;

        if (otherSpec.getTopWood() != this.topWood)
            return false;

        if (otherSpec.getNumStrings() != this.numStrings)
            return false;

        return true;
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
    public int getNumStrings() {
        return numStrings;
    }
}
