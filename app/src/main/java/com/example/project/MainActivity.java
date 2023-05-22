package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=f22linhe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("Vulkaner", json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Vulkaner>>() {}.getType();
        List<Vulkaner> ListOfVolcanos = gson.fromJson(json, type);
        ArrayList<Vulkaner> items = new ArrayList<>();

        for (Vulkaner aktiva : ListOfVolcanos) {
            Log.d("Vulkaner", aktiva.toString());
            items.add(new Vulkaner(aktiva.getID(), aktiva.getName(), aktiva.getLocation(), aktiva.getSize(), aktiva.getCategory()));
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Vulkaner item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
    }

}
