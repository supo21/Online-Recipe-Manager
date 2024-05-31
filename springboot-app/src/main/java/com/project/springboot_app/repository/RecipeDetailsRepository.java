package com.project.springboot_app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot_app.Model.RecipeDetails;

@Repository
public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer>{
    
}