package com.rest.moviesapi.exception;

public class MovieNotFoundException extends Exception {

    public MovieNotFoundException(long movie_id){
        super(String.format("Couldn't find movie with id : %s", movie_id));
    }
}
