package com.abhishek.rest.webservices.restful_web_services.dao;

import com.abhishek.rest.webservices.restful_web_services.dto.User;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
}
