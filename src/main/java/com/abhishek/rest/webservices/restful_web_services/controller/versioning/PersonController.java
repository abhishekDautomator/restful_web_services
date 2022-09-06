package com.abhishek.rest.webservices.restful_web_services.controller.versioning;

import com.abhishek.rest.webservices.restful_web_services.dto.User;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntityV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PersonController {
    @GetMapping(value = "/v1/person")
    public UserEntity getPersonV1(){
        return new UserEntity(1,"Abhishek Narayan", LocalDateTime.now());
    }

    @GetMapping(value = "/v2/person")
    public UserEntityV2 getPersonV2(){
        return new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now());
    }

    @GetMapping(value = "/person",params = "version=1")
    public UserEntity getPersonV1Param(){
        return new UserEntity(1,"Abhishek Narayan", LocalDateTime.now());
    }

    @GetMapping(value = "/person",params = "version=2")
    public UserEntityV2 getPersonV2Param(){
        return new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now());
    }

//    @GetMapping(value = "/person/header", headers = {"X-API-VERSION=1"})
//    public UserEntity getPersonV1HeaderVersioning(){
//        return new UserEntity(1,"Abhishek Narayan", LocalDateTime.now());
//    }
//
//    @GetMapping(value = "/person/header", headers = {"X-API-VERSION=2"})
//    public UserEntityV2 getPersonV2HeaderVersioning(){
//        return new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now());
//    }

    @GetMapping(value = "/person/accept",produces="application/vnd.company.app-v1+json")
    public UserEntity getPersonV1Accept(){
        return new UserEntity(1,"Abhishek Narayan", LocalDateTime.now());
    }

    @GetMapping(value = "/person/accept",produces="application/vnd.company.app-v2+json")
    public UserEntityV2 getPersonV2Accept(){
        return new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now());
    }
}
