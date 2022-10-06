package com.example.recipes.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.recipes.R;
import com.example.recipes.data.RecipesData;
import com.example.recipes.fragment.RecipeDetailsFragment;
import com.example.recipes.models.Recipe;

public class RecipeDetails extends AppCompatActivity {
    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        if (savedInstanceState == null) {
            Bundle extra = getIntent().getExtras();
            int position = extra.getInt("recipe_id");
            recipe = new RecipesData().recipeList().get(position);

            RecipeDetailsFragment fragment = new RecipeDetailsFragment();
            fragment.setArguments(extra); // pass in the bundle here.
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.RecipeDetailsContainer, fragment).commit();
        }
    }
}