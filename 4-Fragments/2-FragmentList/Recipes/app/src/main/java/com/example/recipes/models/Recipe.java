package com.example.recipes.models;

public class Recipe {

    //region *** properties ***
    private String name;
    private int resourceIds;
    private String ingredients;
    private String directions;
    //endregion

    //region *** constructor  ***
    public Recipe(String name, int resourceIds, String ingredients, String directions) {
        this.name = name;
        this.resourceIds = resourceIds;
        this.ingredients = ingredients;
        this.directions = directions;
    }
    //endregion

    //region *** getter and setter ***
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(int resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
    //endregion
}
