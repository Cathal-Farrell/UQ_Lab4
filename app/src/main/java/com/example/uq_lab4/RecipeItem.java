package com.example.uq_lab4;

public class RecipeItem {
    private String name;
    private String date;
    private String message;

    public RecipeItem(String name, String date, String message) {
        this.name = name;
        this.date = date;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
