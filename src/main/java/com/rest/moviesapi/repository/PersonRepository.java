package com.rest.moviesapi.repository;

import com.rest.moviesapi.model.Person;
import com.rest.moviesapi.model.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository for the Person.
 * Here we will write the needed SQL queries to fetch the wanted persons
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Get the infos of a Person on all the movies that person played in
     * @param person_id the id of the person we want to fetch the movies
     * @return A list of PersonDto that will be sent out in a json format
     */
    @Query("SELECT new com.rest.moviesapi.model.dto.PersonDto(p.person_id, p.person_name, mc.character_name, m.movie_id, m.title)" +
    "FROM Person p "+
    "JOIN MovieCast mc ON mc.person_id = p.person_id "+
    "JOIN Movie m ON m.movie_id = mc.movie_id "+
    "WHERE p.person_id = ?1")
    List<PersonDto> fetchMoviesPersonCast(Long person_id);

    /**
     * Get the infos of a Person on all the movies that person worked on
     * @param person_id the id of the person we want to fetch the movies
     * @return A list of PersonDto that will be sent out in a json format
     */
    @Query("SELECT new com.rest.moviesapi.model.dto.PersonDto(p.person_id, p.person_name, m.movie_id, m.title, mc.job) " +
            "FROM Person p " +
            "JOIN MovieCrew mc on mc.person_id = p.person_id " +
            "JOIN Movie m ON m.movie_id = mc.movie_id " +
            "WHERE p.person_id = ?1")
    List<PersonDto> fetchMoviesPersonCrew(Long person_id);

    /**
     * Return a list containing the persons who casted in the movie
     * @param movie_id
     * @return A list of PersonDto that will be sent out in a json format
     */
    @Query("SELECT new com.rest.moviesapi.model.dto.PersonDto(p.person_id, p.person_name, mc.character_name, mc.movie_id, m.title) " +
            "FROM Person p " +
            "JOIN MovieCast mc ON p.person_id = mc.person_id " +
            "JOIN Movie m ON m.movie_id = mc.movie_id " +
            "WHERE mc.movie_id = ?1")
    List<PersonDto> fetchCastMovie(Long movie_id);

    /**
     * Return a list containing the persons who were part of the crew
     * @param movie_id
     * @return A list of PersonDto that will be sent out in a json format
     */
    @Query("SELECT new com.rest.moviesapi.model.dto.PersonDto(p.person_id, p.person_name, m.movie_id, m.title, mc.job) " +
            "FROM Person p " +
            "JOIN MovieCrew mc ON p.person_id = mc.person_id " +
            "JOIN Movie m ON m.movie_id = mc.movie_id " +
            "WHERE mc.movie_id = ?1")
    List<PersonDto> fetchCrewMovie(Long movie_id);
}
