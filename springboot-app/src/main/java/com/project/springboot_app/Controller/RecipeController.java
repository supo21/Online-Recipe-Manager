package com.project.springboot_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//mport org.springframework.web.bind.annotation.RestController;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.service.RecipeService;

import ch.qos.logback.core.model.Model;


@Controller

public class RecipeController {
      @Autowired
     RecipeService recipeService;


    @GetMapping("/")
    public String index(){
        return"index";
    }
    @PostMapping("/register")

//    public Recipe saveRecipe(@RequestParam Recipe recipe){
//       return recipeService.create(recipe);
//     }
      public String save(@ModelAttribute("obj") Recipe recipe,Model model){
       System.out.println("user id "+recipe.getId());
       System.out.println("username is "+recipe.getUsername());
       System.out.println("password is "+recipe.getPassword());
        recipeService.create(recipe);
        System.out.println("successfull");
    
        return "login";
        
      }

}