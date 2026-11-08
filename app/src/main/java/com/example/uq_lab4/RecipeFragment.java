package com.example.uq_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecipeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipeFragment() {
        // Required empty public constructor
    }

    public static RecipeFragment newInstance(String param1, String param2) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        List<RecipeItem> recipeList = new ArrayList<>();

        // https://abhiandroid.com/programming/json/
        try {
            // get JSONArray from JSON file
            JSONArray recipeArray = new JSONArray(loadJSONFromAsset());
            // implement for loop for getting users list data
            for (int i = 0; i < recipeArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject recipeDetail = recipeArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                recipeList.add(new RecipeItem(recipeDetail.getString("name"),
                        recipeDetail.getString("time"),
                        recipeDetail.getString("desc")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Sample data


        //recipeList.add(new RecipeItem("Recipe 1", "1hr", "Description 1"));

        //recipeList.add(new RecipeItem("Recipe 2", "45m", "Description 2"));

        //recipeList.add(new RecipeItem("Recipe 3", "2hr 30m","Description 3"));

        //recipeList.add(new RecipeItem("Recipe 4", "1h 30m","Description 4"));

        //recipeList.add(new RecipeItem("Recipe 5", "25m","Description 5"));

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Set Adapter
        RecipeAdapter adapter = new RecipeAdapter(recipeList, (item, position) -> {
            ((MainActivity) requireActivity()).showIngredients(position);
        });
        recyclerView.setAdapter(adapter);

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