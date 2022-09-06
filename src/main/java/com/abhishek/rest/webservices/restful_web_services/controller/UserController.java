package com.abhishek.rest.webservices.restful_web_services.controller;

import com.abhishek.rest.webservices.restful_web_services.dto.User;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;
import com.abhishek.rest.webservices.restful_web_services.errorHandler.ErrorHandler;
import com.abhishek.rest.webservices.restful_web_services.services.UserServiceImplementation;
import net.bytebuddy.asm.Advice;
import org.hibernate.EntityMode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController          //REST API
public class UserController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> userEntityList = userServiceImplementation.getAllUsers();
        return new ResponseEntity<>(userEntityList, HttpStatus.OK);
    }

    //http://localhost:8888/users
    //EntityModel
    //WebMVCLinkBuilder
    @GetMapping(value = "/users/{id}")
    public EntityModel<ResponseEntity<Object>> getAUser(@PathVariable int id){
        Optional<UserEntity> userEntity = userServiceImplementation.getUser(id);
        EntityModel entityModel;
        if(userEntity.isPresent()) {
            entityModel = EntityModel.of(new ResponseEntity<>(userEntity, HttpStatus.OK));
        }
        else {
            ErrorHandler errorHandler = new ErrorHandler(LocalDateTime.now(),"User Not Found",HttpStatus.NOT_FOUND.value());
            entityModel = EntityModel.of(new ResponseEntity<>(errorHandler.toString(), HttpStatus.NOT_FOUND));
        }

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Integer> deleteAUser(@PathVariable int id){
        Optional<UserEntity> userEntity = userServiceImplementation.getUser(id);
        if(userEntity.isPresent()) {
            userServiceImplementation.deleteUser(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/users")
    public ResponseEntity<UserEntity> addAUser(@RequestBody User user){
        System.out.println(user.toString());
        UserEntity userEntity = modelMapper.map(user,UserEntity.class);
        System.out.println(userEntity.toString());
        UserEntity addedUser = userServiceImplementation.addUser(userEntity);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    private MessageSource messageSource;

    public UserController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/message")
    public String helloWorld(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
        //return "Hello World";
    }
}
