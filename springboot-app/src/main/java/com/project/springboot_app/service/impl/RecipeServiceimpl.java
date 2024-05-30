package com.project.springboot_app.service.impl;//implements herer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.repository.RecipeRepository;
import com.project.springboot_app.service.RecipeService;

@Service
public class RecipeServiceimpl implements RecipeService {

 @Autowired
 RecipeRepository recipeRepository;


    @Override
    public Recipe create(Recipe recipe) {
       
        return recipeRepository.save(recipe);
    }

    
}
