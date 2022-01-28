package com.rest.moviesapi.model.dto;


/**
 * This class will be used as a Data Transfer Object of a Person
 */
public class PersonDto {

    private Long person_id;
    private String person_name;
    private String character_name;
    private String movie_title;
    private Long movie_id;
    private String job;

    /**
     * DTO used for when we want the person as a cast
     * @param person_id
     * @param person_name
     * @param character_name
     * @param movie_id
     * @param movie_title
     */
    public PersonDto(Long person_id, String person_name, String character_name, Long movie_id, String movie_title) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.character_name = character_name;
        this.movie_title = movie_title;
        this.movie_id = movie_id;
    }

    /**
     * DTO used for when we want the person as a crew member
     * @param person_id
     * @param person_name
     * @param job
     * @param movie_id
     * @param movie_title
     */
    public PersonDto(Long person_id, String person_name, Long movie_id, String movie_title, String job) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.job = job;
        this.movie_title = movie_title;
        this.movie_id = movie_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
