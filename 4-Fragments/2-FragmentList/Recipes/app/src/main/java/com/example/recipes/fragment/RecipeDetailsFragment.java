package com.example.recipes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recipes.R;
import com.example.recipes.data.RecipesData;
import com.example.recipes.models.Recipe;


public class RecipeDetailsFragment extends Fragment {

    Recipe recipe;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey("recipe_id")) {
            int position = getArguments().getInt("recipe_id");
            recipe = new RecipesData().recipeList().get(position);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        if (recipe != null) {
            TextView recipeName = view.findViewById(R.id.recipeNameTextId);
            recipeName.setText(recipe.getName());
            ImageView recipeImage = view.findViewById(R.id.recipeImageId);
            recipeImage.setImageResource(recipe.getResourceIds());

        }
        return view;
    }
}