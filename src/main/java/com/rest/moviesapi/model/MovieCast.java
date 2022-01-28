package com.rest.moviesapi.model;

import com.rest.moviesapi.model.id.MovieCastId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Model class for a character
 */
@Entity
@Table(name = "movie_cast")
@IdClass(MovieCastId.class)
public class MovieCast {

    @Id
    private long movie_id;
    @Id
    private long person_id;
    private String character_name;
}
