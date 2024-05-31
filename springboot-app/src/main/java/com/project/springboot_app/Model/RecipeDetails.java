package com.project.springboot_app.Model;

import jakarta.persistence.Column;
//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RecipeDetails {
    @Id
 @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer recipe_id;

    private String recipe_name;
    //ALTER TABLE recipe_details MODIFY recipe_description LONGTEXT;
    @Column(columnDefinition="LONGTEXT")
    private String recipe_description;
    @Column(columnDefinition = "LONGTEXT")
    private String recipe_preparation;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    
}