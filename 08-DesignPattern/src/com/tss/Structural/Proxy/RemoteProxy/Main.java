package com.tss.Structural.Proxy.RemoteProxy;

public class Main {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherServiceProxy();

        System.out.println(weatherService.getWeather("London"));
        System.out.println();
        System.out.println(weatherService.getWeather("London"));
    }
}
