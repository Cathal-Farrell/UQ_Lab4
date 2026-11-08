package com.example.uq_lab4;

public class RecipeItem {
    private String name;
    private String time;
    private String desc;

    public RecipeItem(String name, String time, String desc) {
        this.name = name;
        this.time = time;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }
}
