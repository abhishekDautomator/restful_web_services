package com.abhishek.rest.webservices.restful_web_services.services;

import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUser(int id);
    void deleteUser(int id);
    UserEntity addUser(UserEntity user);
}
