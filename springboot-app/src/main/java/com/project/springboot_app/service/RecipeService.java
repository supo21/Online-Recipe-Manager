package com.project.springboot_app.service;

import org.springframework.stereotype.Service;

import com.project.springboot_app.Model.Recipe;


@Service
public interface RecipeService {


    public Recipe create(Recipe recipe);

    
    
}
