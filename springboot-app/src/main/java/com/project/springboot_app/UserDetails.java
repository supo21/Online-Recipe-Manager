package com.project.springboot_app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.Data;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@Data//Annotaiton for Getter/Setter methods

public class UserDetails {
    String username;
    String password;

    
}
