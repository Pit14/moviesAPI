package com.rest.moviesapi.model.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Will be used as the id for the MovieCast class
 */
public class MovieCastId implements Serializable {

    private long movie_id;
    private long person_id;

    public MovieCastId(long movie_id, long person_id) {
        this.movie_id = movie_id;
        this.person_id = person_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCastId that = (MovieCastId) o;
        return movie_id == that.movie_id && person_id == that.person_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, person_id);
    }
}
