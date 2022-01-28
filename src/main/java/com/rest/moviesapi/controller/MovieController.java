package com.rest.moviesapi.controller;

import com.rest.moviesapi.Constants;
import com.rest.moviesapi.exception.MovieNotFoundException;
import com.rest.moviesapi.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rest.moviesapi.repository.MovieRepository;
import java.util.List;

//TODO Make a password so not everyone can update or delete movies

/**
 * Controller class for the Movie object.
 * Here we map the API url
 */
@CrossOrigin(origins = Constants.origins)
@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Get all the movies in the DB
     * @return A list of Movies
     */
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     *
     * @param movie
     * @return
     */
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Get a single movie
     * @param movie_id The id of the movie
     * @return A Movie object
     * @throws MovieNotFoundException
     */
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable(value = "id") Long movie_id) throws MovieNotFoundException {
        return movieRepository.findById(movie_id)
                .orElseThrow(() -> new MovieNotFoundException(movie_id));
    }

    /**
     * To update a given movie
     * @param movie_id The movie to update
     * @param movieDetails The new movie
     * @return The movie updated
     * @throws MovieNotFoundException
     */
    @PutMapping("/movies/{id}")
    public Movie updateNote(@PathVariable(value = "id") Long movie_id,
                            @RequestBody Movie movieDetails) throws MovieNotFoundException {

        Movie movie = movieRepository.findById(movie_id)
                .orElseThrow(() -> new MovieNotFoundException(movie_id));

        movie.setTitle(movieDetails.getTitle());
        movie.setBudget(movieDetails.getBudget());
        movie.setHomepage(movieDetails.getHomepage());
        movie.setMovie_status(movieDetails.getMovie_status());
        movie.setOverview(movieDetails.getOverview());
        movie.setPopularity(movieDetails.getPopularity());
        movie.setRelease_date(movieDetails.getRelease_date());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setVote_count(movieDetails.getVote_count());
        movie.setTagline(movieDetails.getTagline());
        movie.setVote_average(movieDetails.getVote_average());
        movie.setRevenue(movieDetails.getRevenue());

        Movie updatedMovie = movieRepository.save(movie);

        return updatedMovie;
    }

    /**
     * Delete a movie
     * @param movie_id
     * @return
     * @throws MovieNotFoundException
     */
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long movie_id) throws MovieNotFoundException {
        Movie movie = movieRepository.findById(movie_id)
                .orElseThrow(() -> new MovieNotFoundException(movie_id));

        movieRepository.delete(movie);

        return ResponseEntity.ok().build();
    }
}
