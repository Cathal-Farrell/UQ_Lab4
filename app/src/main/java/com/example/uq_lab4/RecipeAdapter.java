package com.example.uq_lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {
    List<RecipeItem> recipeList;
    public RecipeAdapter(List<RecipeItem> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        RecipeItem recipeItem = recipeList.get(position);

        holder.recipeName.setText(recipeItem.getName());
        holder.recipeDate.setText(recipeItem.getDate());
        holder.recipeMessage.setText(recipeItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    // ViewHolder class
    static class RecipeHolder extends RecyclerView.ViewHolder {
        TextView recipeName, recipeDate, recipeMessage;

        public RecipeHolder(@NonNull View itemView) {

            super(itemView);

            recipeName = itemView.findViewById(R.id.recipeName);
            recipeDate = itemView.findViewById(R.id.recipeDate);
            recipeMessage = itemView.findViewById(R.id.recipeMessage);
        }
    }
}
