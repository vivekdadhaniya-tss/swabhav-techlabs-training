package com.tss.ass2.exception;

public class NoSuchMovieFoundException extends RuntimeException{

    public NoSuchMovieFoundException() {
    }

    @Override
    public String getMessage() {
        return "No such movie found";
    }
}
