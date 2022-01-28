package com.rest.moviesapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for the Department class
 */
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue
    private String department_id;

    private String department_name;

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    @Id
    public String getDepartment_id() {
        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
