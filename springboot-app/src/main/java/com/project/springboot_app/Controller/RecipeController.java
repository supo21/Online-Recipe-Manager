package com.project.springboot_app.Controller;

import java.util.List;

//import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
     private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);
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

            .header("Location", "listrecipe")
            .body(savedRecipe);
   // return ResponseEntity.ok(savedRecipe);

   }
//   @PostMapping("/save_recipe")
// public String saveRecipe(@RequestParam("image") MultipartFile image,
//                          @RequestParam("id") int recipe_id,
//                          @RequestParam("name") String recipe_name,
//                          @RequestParam("desc") String recipe_description,
//                          @RequestParam("prep") String recipe_preparation,
//                          Model model) {
//     // Save the recipe using the service
//    // RecipeDetails savedRecipe = recipeService.saveRecipe(image, recipe_id, recipe_name, recipe_description, recipe_preparation);
    
    
//     System.out.println(recipe_id);
    
   
//     // model.addAttribute("savedRecipe", savedRecipe);
    
//     // // Redirecting to the desired HTML page
//     // return "listrecipe";
//     List<RecipeDetails> recipeItems = recipeService.getAllRecipe();
//     model.addAttribute("recipeItems", recipeItems);
//   System.out.println("i am here okayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//     // Redirecting to the desired HTML page
//     return "redirect:/recipelist";

// }
//RequestMapping("/recipelist")
@GetMapping("/recipelist")
    public String getRecipes(Model model) {
      logger.info("Fetching all recipes");
        List<RecipeDetails> recipeItems = recipeService.getAllRecipe();
        logger.info("Number of recipes found: {}", recipeItems.size());
        model.addAttribute("recipeItems", recipeItems);

        return "recipelist";
    }



}