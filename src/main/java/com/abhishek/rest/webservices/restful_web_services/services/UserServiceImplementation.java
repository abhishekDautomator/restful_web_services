package com.abhishek.rest.webservices.restful_web_services.services;

import com.abhishek.rest.webservices.restful_web_services.dao.UserDao;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<UserEntity> getUser(int id) {
        Optional<UserEntity> retrievedUser = userDao.findById(id);
        return retrievedUser;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }
}
