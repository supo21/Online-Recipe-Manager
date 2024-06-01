package com.project.springboot_app.Controller;
import java.util.List;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.springboot_app.Model.RecipeDetails;
import com.project.springboot_app.repository.RecipeDetailsRepository;

public class ViewController {
    @Autowired
    private RecipeDetailsRepository recipeDetailsRepository;



    @RequestMapping(value = "/listRecipe",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView returnlistrecipe()
    {
        ModelAndView mv=new ModelAndView();
        List<RecipeDetails> recipeList=recipeDetailsRepository.findAll();
        mv.setViewName("recipe_item");
        mv.addObject("recipe_item", recipeList);
        return mv;
    }
}
