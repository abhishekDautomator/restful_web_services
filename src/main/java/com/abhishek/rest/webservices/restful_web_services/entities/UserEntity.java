package com.abhishek.rest.webservices.restful_web_services.entities;

import com.abhishek.rest.webservices.restful_web_services.dto.Post;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.id.IncrementGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "user_data")
//@JsonFilter("user-filter")
public class UserEntity {

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    @Column(nullable = false)
    @Size(min=2, message = "Name should have at least 2 characters")
    @JsonProperty("user_name")
    private String name;

    @Column(nullable = false)
    @Past(message = "DOB should be of past")
    @JsonProperty("birth_date")
    private LocalDateTime dateOfBirth;

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserEntity(Integer id, String name, LocalDateTime dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
