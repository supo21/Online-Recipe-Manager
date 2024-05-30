package com.project.springboot_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.service.FetchingService;
//import com.project.springboot_app.service.RecipeService;

import ch.qos.logback.core.model.Model;


@Controller

public class FetchingController {
      @Autowired
     FetchingService fetchingService;


    @GetMapping("/login")
    public String index(){
        return"index";
    }
   

//    public Recipe saveRecipe(@RequestParam Recipe recipe){
//       return recipeService.create(recipe);
//     }
@PostMapping("/admin")
public String authenticateUser(@ModelAttribute("loginForm") Recipe loginForm, Model model) {
    boolean authenticatedUser = fetchingService.authenticate(loginForm.getId(),loginForm.getUsername(), loginForm.getPassword());
    if (authenticatedUser) {
        return "sucess"; //admin page
    } else {
       // model.addAttribute("error", "Invalid username or password");
        return "unsucess"; 
    }
}

}