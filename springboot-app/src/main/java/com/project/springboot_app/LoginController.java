package com.project.springboot_app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
