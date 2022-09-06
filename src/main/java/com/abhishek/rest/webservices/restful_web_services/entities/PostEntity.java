package com.abhishek.rest.webservices.restful_web_services.entities;

import com.abhishek.rest.webservices.restful_web_services.dto.User;

import javax.persistence.*;

@Entity
public class PostEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String description;

    public PostEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
