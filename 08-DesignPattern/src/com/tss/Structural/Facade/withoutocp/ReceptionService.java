package com.tss.Structural.Facade.withoutocp;

public class ReceptionService {

    private LuggageService luggageService;
    private RestaurantService restaurantService;
    private RoomService roomService;

    public ReceptionService() {
        luggageService = new LuggageService();
        restaurantService = new RestaurantService();
        roomService = new RoomService();
    }

    public void checkIn() {
        System.out.println("Guest Check-In Started...");
        roomService.cleanRoom();
        luggageService.pickLuggage();
        luggageService.dropLuggage();
        restaurantService.serveFood();
        System.out.println("Guest Check-In Completed.");
    }

    public void checkOut() {
        System.out.println("Guest Check-Out Started...");
        luggageService.pickLuggage();
        System.out.println("Generating bill...");
        System.out.println("Guest Check-Out Completed.");
    }
}
