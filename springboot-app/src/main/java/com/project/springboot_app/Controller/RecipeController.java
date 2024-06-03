package com.project.springboot_app.Controller;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//mport org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

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
    @GetMapping("/addrecipe")
    public String addrecipe(){
      return "addrecipe";
    }
    @GetMapping("/deleterecipe/{recipe_id}")
    public String delete(@PathVariable  Integer recipe_id,Model model){

            recipeService.deleterecipeById(recipe_id);
            List<RecipeDetails> allrecipe=recipeService.getAllRecipe();
            model.addAttribute("recipeItems", allrecipe);
            return "recipelist";
    }


    @GetMapping("/recipe/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        RecipeDetails recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "editrecipe";
    }

    @PostMapping("/recipe/{id}")
    public String updateRecipe(@PathVariable Integer id,
                               @ModelAttribute RecipeDetails recipeDetails,
                               @RequestParam("imageFile") MultipartFile imageFile,
                               Model model) throws IOException {
        if (!imageFile.isEmpty()) {
            String base64Image = Base64.getEncoder().encodeToString(imageFile.getBytes());
            recipeDetails.setImage(base64Image);
        }
        recipeService.updaterecipeById(id, recipeDetails);
        model.addAttribute("recipeItems", recipeService.getAllRecipe());
        return "recipelist";
    }
                                              

                                               


   @PostMapping("/save_recipe")
    public ResponseEntity<RecipeDetails> saveRecipe(@RequestParam("image") MultipartFile image,
   @RequestParam("id") int recipe_id,
   @RequestParam("name") String recipe_name,
   @RequestParam("desc") String recipe_description,
   @RequestParam("prep") String recipe_preparation,
   Model model){
     // return recipeService.saveRecipe(image, recipe_id, recipe_name, recipe_description,recipe_preparation);
     // RecipeDetails savedRecipe = recipeService.saveRecipe(image, recipe_id,recipe_name, recipe_description, recipe_preparation);
     // System.out.println(recipe_id); 
      RecipeDetails savedRecipe = recipeService.saveRecipe(image, recipe_id, recipe_name, recipe_description, recipe_preparation);
    System.out.println(recipe_id);

   // Add attributes to the model
   model.addAttribute("recipe", savedRecipe);

   //You can add other necessary attributes as well
   // For example, if you want to pass a list of all recipes
    List<RecipeDetails> allRecipes = recipeService.getAllRecipe();
   model.addAttribute("recipeItems", allRecipes);

    // Create a URI for redirection (you can include additional query parameters if necessary)
    URI location = UriComponentsBuilder.fromPath("/recipelist")
                                       .build()
                                       .toUri();

    return ResponseEntity.status(HttpStatus.FOUND)
                         .location(location)
                         .body(savedRecipe);
      // return ResponseEntity.status(HttpStatus.FOUND)

      //       .header("Location", "recipelist")
      //       .body(savedRecipe);
            
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
        System.out.println("i am herereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        model.addAttribute("recipeItems", recipeItems);

        return "recipelist";
    }
   



}