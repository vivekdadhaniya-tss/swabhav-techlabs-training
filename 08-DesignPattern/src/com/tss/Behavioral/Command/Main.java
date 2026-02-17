package com.tss.Behavioral.Command;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();

        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(turnOff);
        remote.pressButton();
        remote.pressUndo();
    }
}
