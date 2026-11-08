package com.example.uq_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // Sample data
        List<IngredientItem> ingredientList = new ArrayList<>();

        // https://abhiandroid.com/programming/json/
        try {
            // get JSONArray from JSON file
            JSONArray recipeArray = new JSONArray(loadJSONFromAsset());
            // pick the selected recipe
            JSONObject recipe = recipeArray.getJSONObject(recipeIndex);
            // get its ingredients sub-array
            JSONArray ingredientArray = recipe.getJSONArray("ingredients");
            // implement for loop for getting users list data
            for (int i = 0; i < ingredientArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject ingredientDetail = ingredientArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                ingredientList.add(new IngredientItem(ingredientDetail.getString("name"),
                        ingredientDetail.getString("method")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Set Adapter
        IngredientAdapter adapter = new IngredientAdapter(ingredientList);
        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("recipes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}