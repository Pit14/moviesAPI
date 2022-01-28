package com.rest.moviesapi.model.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Will be used as the id for the MovieCrew class
 */
public class MovieCrewId implements Serializable {

    private long movie_id;
    private long person_id;
    private long department_id;

    public MovieCrewId(long movie_id, long person_id, long department_id) {
        this.movie_id = movie_id;
        this.person_id = person_id;
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCrewId that = (MovieCrewId) o;
        return movie_id == that.movie_id &&
                person_id == that.person_id &&
                department_id == that.department_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, person_id, department_id);
    }
}
