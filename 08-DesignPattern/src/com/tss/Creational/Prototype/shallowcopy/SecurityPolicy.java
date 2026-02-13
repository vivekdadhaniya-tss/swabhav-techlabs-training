package com.tss.Creational.Prototype.shallowcopy;

public class SecurityPolicy {
    String level;

    public SecurityPolicy(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
    }
}
