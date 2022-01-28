package com.rest.moviesapi.repository;

import com.rest.moviesapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the Movie.
 * Here we will write the needed SQL query to fetch the wanted movies
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {


}
