package com.tss.ass2.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private static int idCounter = 1;
    private final int id;
    private String name;
    private int year;
    private String genre;

    public Movie(String name, int year, String genre) {
        this.id = idCounter++;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Movie.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
