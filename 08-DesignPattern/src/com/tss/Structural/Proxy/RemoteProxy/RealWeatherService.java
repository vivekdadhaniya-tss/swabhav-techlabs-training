package com.tss.Structural.Proxy.RemoteProxy;

public class RealWeatherService implements WeatherService{
    @Override
    public String getWeather(String city) {
        System.out.println("Fetching weather from remote API for: " + city);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for weather for: " + e.getMessage());
        }

        return "Weather in " + city + " is Sunny";
    }
}
