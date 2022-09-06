package com.abhishek.rest.webservices.restful_web_services.filter;

import com.abhishek.rest.webservices.restful_web_services.entities.UserEntity;
import com.abhishek.rest.webservices.restful_web_services.entities.UserEntityV2;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping(value = "/filter")
    public UserEntityV2 filtering(){
        return new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now());
    }

    @GetMapping(value = "/filter-list")
    public List<UserEntityV2> listFiltering(){
        return Arrays.asList(new UserEntityV2(1,"Abhishek","Narayan", LocalDateTime.now()),
                new UserEntityV2(2,"Anupriya","Sah", LocalDateTime.now()));
    }

    @GetMapping(value = "/filter/dynamic")
    public MappingJacksonValue dynamicFiltering(){
        UserEntity userEntity = new UserEntity(1,"Abhishek Narayan", LocalDateTime.now());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userEntity);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("user-filter", SimpleBeanPropertyFilter.filterOutAllExcept("id", "user_name"));
        mappingJacksonValue.setFilters(filterProvider);
        return  mappingJacksonValue;
    }
}
