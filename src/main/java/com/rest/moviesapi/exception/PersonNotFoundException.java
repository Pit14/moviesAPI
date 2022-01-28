package com.rest.moviesapi.exception;

public class PersonNotFoundException extends Exception {


    public PersonNotFoundException(long person_id) {
        super(String.format("Couldn't find person with id : %s", person_id));
    }
}

