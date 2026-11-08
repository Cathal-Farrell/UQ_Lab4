package com.example.uq_lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    public interface OnItemClickListener {
        void onItemClick(RecipeItem item, int position);
    }

    List<RecipeItem> recipeList;
    private final OnItemClickListener listener;
    public RecipeAdapter(List<RecipeItem> recipeList, OnItemClickListener listener) {
        this.recipeList = recipeList;
        this.listener = listener;
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
        holder.recipeTime.setText(recipeItem.getTime());
        holder.recipeDesc.setText(recipeItem.getDesc());

        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getBindingAdapterPosition();
            listener.onItemClick(recipeList.get(pos), pos);
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    // ViewHolder class
    static class RecipeHolder extends RecyclerView.ViewHolder {
        TextView recipeName, recipeTime, recipeDesc;

        public RecipeHolder(@NonNull View itemView) {

            super(itemView);

            recipeName = itemView.findViewById(R.id.recipeName);
            recipeTime = itemView.findViewById(R.id.recipeTime);
            recipeDesc = itemView.findViewById(R.id.recipeDesc);
        }
    }
}
