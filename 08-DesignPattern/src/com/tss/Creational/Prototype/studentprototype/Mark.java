package com.tss.Creational.Prototype.studentprototype;

public class Mark implements  Prototype<Mark> {

    private int score;

    public Mark(int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // For shallow/deep copy, primitive is fine
    @Override
    public Mark clone() {
        return new  Mark(this.score);   // always deep copy works here
    }

    @Override
    public String toString() {
        return "Mark: " + score;
    }

}
