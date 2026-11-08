package com.example.uq_lab4;

public class IngredientItem {
    private String name;
    private String method;

    public IngredientItem(String name, String method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public String getMethod() {
        return method;
    }
}
