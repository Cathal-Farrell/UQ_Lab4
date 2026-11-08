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

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientHolder> {

    public interface OnItemClickListener {
        void onItemClick(IngredientItem item, int position);
    }

    List<IngredientItem> IngredientList;
    public IngredientAdapter(List<IngredientItem> IngredientList) {
        this.IngredientList = IngredientList;
    }

    @NonNull
    @Override
    public IngredientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ingredient, parent, false);
        return new IngredientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientHolder holder, int position) {
        IngredientItem IngredientItem = IngredientList.get(position);

        holder.IngredientName.setText(IngredientItem.getName());
        holder.IngredientMethod.setText(IngredientItem.getMethod());
    }

    @Override
    public int getItemCount() {
        return IngredientList.size();
    }

    // ViewHolder class
    static class IngredientHolder extends RecyclerView.ViewHolder {
        TextView IngredientName, IngredientMethod;

        public IngredientHolder(@NonNull View itemView) {

            super(itemView);

            IngredientName = itemView.findViewById(R.id.IngredientName);
            IngredientMethod = itemView.findViewById(R.id.IngredientMethod);
        }
    }
}
