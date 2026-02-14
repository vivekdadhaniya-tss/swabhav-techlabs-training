package com.tss.Structural.Facade.withoutocp;

public class Main {

    public static void main(String[] args) {
        ReceptionService reception = new ReceptionService();

        reception.checkIn();
        System.out.println("-------------------");
        reception.checkOut();
    }
}
