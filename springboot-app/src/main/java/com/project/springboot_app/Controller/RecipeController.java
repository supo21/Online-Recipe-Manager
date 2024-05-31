package com.project.springboot_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//mport org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.Model.RecipeDetails;
import com.project.springboot_app.service.RecipeService;

//import ch.qos.logback.core.model.Model;


@Controller

public class RecipeController {
      @Autowired
     RecipeService recipeService;


    @GetMapping("/")
    public String index(){
        return"admin";
    }
    @PostMapping("/save_recipe")
    public ResponseEntity<RecipeDetails> saveRecipe(@RequestParam("image") MultipartFile image,
   @RequestParam("id") int recipe_id,
   @RequestParam("name") String recipe_name,
   @RequestParam("desc") String recipe_description,
   @RequestParam("prep") String recipe_preparation){
     // return recipeService.saveRecipe(image, recipe_id, recipe_name, recipe_description,recipe_preparation);
      RecipeDetails savedRecipe = recipeService.saveRecipe(image, recipe_id,recipe_name, recipe_description, recipe_preparation);
      System.out.println(recipe_id); 
      return ResponseEntity.status(HttpStatus.FOUND)
            .header("Location", "login")
            .body(savedRecipe);
   // return ResponseEntity.ok(savedRecipe);

   }


}