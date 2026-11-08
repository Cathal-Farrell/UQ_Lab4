package com.example.uq_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IngredientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngredientFragment extends Fragment {
    private static final String ARG_INDEX = "recipe_index";
    private int recipeIndex;

    public IngredientFragment() {
        // Required empty public constructor
    }

    public static IngredientFragment newInstance(int index) {
        IngredientFragment fragment = new IngredientFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipeIndex = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getContext(),
                "Clicked: " + recipeIndex,
                Toast.LENGTH_SHORT).show();

        // Sample data
        List<List<RecipeItem>> recipeList = new ArrayList<>();


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient, container, false);
    }
}