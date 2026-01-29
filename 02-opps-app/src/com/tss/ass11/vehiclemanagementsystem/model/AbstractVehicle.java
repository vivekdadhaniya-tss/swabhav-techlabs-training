package com.tss.ass11.vehiclemanagementsystem.model;

public abstract class AbstractVehicle implements Vehicle {

    private static int idCounter = 1;

    protected int id;
    protected boolean running;

    public AbstractVehicle() {
        this.id = idCounter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void start() {
        running = true;
        System.out.println(getClass().getSimpleName() + " " + id + " started");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println(getClass().getSimpleName() + " " + id + " stopped");
    }

    @Override
    public String getStatus() {
        return running ? "Running" : "Stopped";
    }
}
