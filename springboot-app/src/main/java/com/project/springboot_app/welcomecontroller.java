package com.project.springboot_app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Controller

public class welcomecontroller{
    @GetMapping("/welcome")
    public String welcome(){
        return "index";
    }

}