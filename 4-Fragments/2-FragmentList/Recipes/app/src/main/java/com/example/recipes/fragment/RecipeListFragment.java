package com.example.recipes.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.recipes.R;
import com.example.recipes.adapter.RecipeAdapter;
import com.example.recipes.data.RecipesData;
import com.example.recipes.models.Recipe;
import com.example.recipes.utils.CallBacks;

import java.util.List;

public class RecipeListFragment extends ListFragment {

    //region *** properties ***
    List<Recipe> recipes = new RecipesData().recipeList();
    private CallBacks activity;
    //endregion


    //region *** constructor ***
    public RecipeListFragment() {
    }
    //endregion

    //region *** onCreate()--> creates mudle of data  ***
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecipeAdapter adapter = new RecipeAdapter(requireActivity(), R.layout.recipie_list_item, recipes);
        setListAdapter(adapter);
    }
    //endregion

    //region ***  View onCreateView --> create views for list ***
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipeitem, container, false);
    }
    //endregion

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Recipe recipe = recipes.get(position);
        this.activity.onItemSelected(recipe, position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (CallBacks) context;
    }
}
