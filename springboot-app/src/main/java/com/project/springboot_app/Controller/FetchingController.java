package com.project.springboot_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.Model.RecipeDetails;
import com.project.springboot_app.service.FetchingService;
import com.project.springboot_app.service.RecipeService;
//import com.project.springboot_app.service.RecipeService;


@Controller

public class FetchingController {
      @Autowired
     FetchingService fetchingService;
     @Autowired
     RecipeService recipeService;

     RecipeDetails recipeDetails;



    @GetMapping("/login")
    public String index(){
        return"index";
    }
   

//    public Recipe saveRecipe(@RequestParam Recipe recipe){
//       return recipeService.create(recipe);
//     }
@PostMapping("/admin")
public String authenticateUser(@ModelAttribute("loginForm") Recipe loginForm,Model model) {
    boolean authenticatedUser = fetchingService.authenticate(loginForm.getId(),loginForm.getUsername(), loginForm.getPassword());
   // List<RecipeDetails>=  recipeDetailsRepository.findAll();
    
    System.out.println("i am nopeeeeeeeeeee");
    List<RecipeDetails> allrecipe=recipeService.getAllRecipe();
    System.out.println("value of all recipe is "+allrecipe);
    
    if (authenticatedUser) {
    model.addAttribute("recipeItems",allrecipe);
        return "home"; //admin page
    } else {
       // model.addAttribute("error", "Invalid username or password");
        return "unsucess"; 
    }
}

}