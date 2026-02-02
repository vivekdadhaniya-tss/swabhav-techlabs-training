package com.tss.ass2.service;

import com.tss.ass2.exception.CapacityFullException;
import com.tss.ass2.exception.NoSuchMovieFoundException;
import com.tss.ass2.model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private List<Movie> movies;
    private static final int CAPACITY = 5;
    private static final String FILE_PATH = "C:\\Users\\vivek.dadhaniya\\Documents\\swabhav-techlabs-training\\code\\03-FileHandling\\src\\com\\tss\\ass2\\movies.txt";

    public MovieManager() {
        movies = loadMovies();
        updateIdCounter();
    }

    private void updateIdCounter() {
        int maxId = movies.size();
        Movie.setIdCounter(maxId + 1);
    }


    private ArrayList<Movie> loadMovies() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            return (ArrayList<Movie>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error loading movies: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void addMovie(Movie movie) {
        if(movies.size() >= CAPACITY) {
            throw new CapacityFullException(CAPACITY);
        }
        movies.add(movie);
        saveMovies();
    }

    private void saveMovies() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(movies);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void clearAllMovies() {
        if(movies.isEmpty()) {
            System.out.println("No movies available so first add the movies.");
            return;
        }
        movies.clear();
        saveMovies();
        Movie.setIdCounter(1);
        System.out.println("All movies cleared");
    }

    public List<Movie> getMovies() {
        if (movies.isEmpty()) {
            throw new NoSuchMovieFoundException();
        }
        return movies;
    }

    public boolean updateMovieById(int id, String name, int year, String genre) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                movie.setName(name);
                movie.setYear(year);
                movie.setGenre(genre);
                saveMovies();
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovieById(int id) {
        boolean removed = movies.removeIf(movie -> movie.getId() == id);
        if (removed) {
            saveMovies();
        }
        return removed;
    }
}
