package com.rest.moviesapi.controller;
import com.rest.moviesapi.Constants;
import com.rest.moviesapi.model.Person;
import com.rest.moviesapi.model.dto.PersonDto;
import com.rest.moviesapi.repository.PersonRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for the Person object.
 * Here we map the API url
 */
@CrossOrigin(origins = Constants.origins)
@RestController
public class PersonController {

    private final PersonRepository personRepository;


    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * To get the list of all the persons in the database.
     * @return The returned fields are : person_id, person_name
     */
    @GetMapping("/persons")
    public List<Person> getAllMovies() {return personRepository.findAll();
    }

    /**
     * To get a list of all the movies a person has played in
     * @param person_id
     * @return The returned fields are : person_id, person_name, character_name, movie_title, movie_id,
     * job (null here cause the job field is for the movies as crew)
     */
    @GetMapping("/person/cast/{id}")
    public List<PersonDto> getMoviesPersonCast(@PathVariable(value = "id") Long person_id){
        return personRepository.fetchMoviesPersonCast(person_id);
    }

    /**
     * To get a list of all the movies a person has been in the crew
     * @param person_id
     * @return The returned fields are : person_id, person_name,
     * character_name (null here cause the job field is for the movies as cast), movie_title, movie_id, job
     */
    @GetMapping("/person/crew/{id}")
    public List<PersonDto> getMoviesPersonCrew(@PathVariable(value = "id") Long person_id){
        return personRepository.fetchMoviesPersonCrew(person_id);
    }

    /**
     * To get all the cast of one movie
     * @param movie_id
     * @return The returned fields are : person_id, person_name, character_name, movie_title, movie_id,
     * job (null here cause the job field is for the movies as cast)
     */
    @GetMapping("/movie/cast/{id}")
    public List<PersonDto> getCastMovie(@PathVariable(value = "id") Long movie_id){
        return personRepository.fetchCastMovie(movie_id);
    }

    /**
     * To get all the crew of one movie
     * @param movie_id
     * @return The returned fields are : person_id, person_name,
     * character_name (null here cause the job field is for the movies as cast), movie_title, movie_id, job
     */
    @GetMapping("/movie/crew/{id}")
    public List<PersonDto> getCrewMovie(@PathVariable(value = "id") Long movie_id){
        return personRepository.fetchCrewMovie(movie_id);
    }




}
