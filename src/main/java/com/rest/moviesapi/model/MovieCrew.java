package com.rest.moviesapi.model;


import com.rest.moviesapi.model.id.MovieCrewId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "movie_crew")
@IdClass(MovieCrewId.class)
public class MovieCrew {

    @Id
    private long movie_id;
    @Id
    private long person_id;
    @Id
    private long department_id;
    private String job;
}
