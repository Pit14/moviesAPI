package com.rest.moviesapi.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Model for the Person class
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private long person_id;

    private String person_name;

    @OneToMany(targetEntity = Movie.class, mappedBy = "movie_id", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Movie> movies;

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
