package com.tss.Creational.Prototype.deepcopy;

class SecurityPolicy {
    String level;

    public SecurityPolicy(String level) {
        this.level = level;
    }

    // Deep copy constructor
    public SecurityPolicy(SecurityPolicy sp) {
        this.level = sp.level;
    }

    @Override
    public String toString() {
        return level;
    }
}
