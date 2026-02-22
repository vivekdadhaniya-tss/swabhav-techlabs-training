package com.tss.ooad.chap03_dog_doors_updated;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;
    private Bark allowedBark;

    public DogDoor() {
        this.open = false;
    }

    public void open() {
        System.out.println("The dog door opens.");
        this.open = true;

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setAllowedBark(Bark allowedBark) {
        this.allowedBark = allowedBark;
    }

    public Bark getAllowedBark() {
        return allowedBark;
    }
}