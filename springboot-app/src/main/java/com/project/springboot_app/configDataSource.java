package com.project.springboot_app;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.liquibase.DataSourceClosingSpringLiquibase;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class configDataSource {
    @Bean public static DataSource source(){
        DataSourceBuilder<?> dSB=DataSourceBuilder.create();
        dSB.driverClassName("com.mysql.cj.jdbc.Driver");
        dSB.url("jdbc:mysql://localhost:3306/recipe_admin");
        dSB.username("root");
        dSB.password("");
        System.out.println("connetion successfull");
        return dSB.build();

    }

    
}
