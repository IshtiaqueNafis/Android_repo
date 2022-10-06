package com.example.recipes.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.recipes.R;
import com.example.recipes.fragment.RecipeListFragment;
import com.example.recipes.models.Recipe;
import com.example.recipes.utils.CallBacks;

public class MainActivity extends AppCompatActivity implements CallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.placeholder);
        if (fragment == null) {
            fragment = new RecipeListFragment();
            fm.beginTransaction().add(R.id.placeholder, fragment).commit();
        }


    }

    @Override
    public void onItemSelected(Recipe recipe, int position) {
        Intent intent = new Intent(this, RecipeDetails.class);
        intent.putExtra("recipe_id", position);
        startActivity(intent);
    }
}