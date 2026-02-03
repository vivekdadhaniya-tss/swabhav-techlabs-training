package com.tss.ass2.controller;

import com.tss.ass2.service.MovieManager;
import com.tss.ass2.model.Movie;

import java.util.Scanner;

public class MovieController {

    private final MovieManager manager;
    private final Scanner scanner;

    public MovieController() {
        manager = new MovieManager();
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        displayMovies();
                        break;
                    case 2:
                        addMovie();
                        break;
                    case 3:
                        updateMovie();
                        break;
                    case 4:
                        deleteMovie();
                        break;
                    case 5:
                        manager.clearAllMovies();
                        break;
                    case 6:
                        System.out.println("Exiting application");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Movie Store Menu ---");
        System.out.println("1. Display Movies");
        System.out.println("2. Add Movie");
        System.out.println("3. Update Movie");
        System.out.println("4. Delete Movie");
        System.out.println("5. Clear All");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private void displayMovies() {
        manager.getMovies()
                .forEach(System.out::println);
    }

    private void addMovie() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        Movie movie = new Movie(name, year, genre);
        manager.addMovie(movie);
        System.out.println("Movie added successfully");
    }

    private void updateMovie() {
        System.out.print("Enter Movie ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter new Year: ");
        int year = scanner.nextInt();

        manager.updateMovieById(id, name, year, genre);
        System.out.println("Movie updated successfully");
    }

    private void deleteMovie() {
        System.out.print("Enter Movie ID to delete: ");
        int id = scanner.nextInt();

        manager.deleteMovieById(id);
        System.out.println("Movie deleted successfully");
    }
}