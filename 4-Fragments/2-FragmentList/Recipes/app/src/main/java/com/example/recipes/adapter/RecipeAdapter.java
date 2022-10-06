package com.example.recipes.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.recipes.R;
import com.example.recipes.models.Recipe;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private final Context context;
    private final List<Recipe> recipes;

    public RecipeAdapter(@NonNull Context context, int resource, @NonNull List<Recipe> recipes) {
        super(context, resource, recipes);
        this.context = context;
        this.recipes = recipes;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Recipe recipe = recipes.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); // getting the inflater
        View view = inflater.inflate(R.layout.recipie_list_item, null);
        ImageView imageView = view.findViewById(R.id.recipeImageId);
        imageView.setImageResource(recipe.getResourceIds());
        TextView textview = view.findViewById(R.id.recipeNameId);
        textview.setText(recipe.getName());
        return view;

    }
}
