package com.tss.Structural.Proxy.RemoteProxy;

import java.util.HashMap;
import java.util.Map;

public class WeatherServiceProxy implements WeatherService{

    private RealWeatherService realWeatherService;
    Map<String, String> cache = new HashMap<>();

    public WeatherServiceProxy(){
        this.realWeatherService = new RealWeatherService();
    }

    @Override
    public String getWeather(String city) {

        if(cache.containsKey(city)){
            System.out.println("Returning cached weather for: " + city);
            return cache.get(city);
        }

        String weather = realWeatherService.getWeather(city);
        cache.put(city, weather);

        return weather;
    }
}
