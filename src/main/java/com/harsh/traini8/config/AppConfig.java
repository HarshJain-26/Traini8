package com.harsh.traini8.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // Configuration file to create ModelMapper bean

    @Bean
    ModelMapper modelMapperBean() { // create modelMapper bean

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // match attributes of entity-model and dto
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); // enable access to private variables

        return modelMapper;
    }

}
