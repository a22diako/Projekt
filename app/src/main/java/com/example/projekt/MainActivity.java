package com.example.projekt;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22diako";
    private final String JSON_FILE = "hp url ";

    ArrayList<RecyclerViewItem> items = new ArrayList<>();
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>(Arrays.asList(
                new RecyclerViewItem("HP2021"),
                new RecyclerViewItem("HP2022"),
                new RecyclerViewItem("HP2020")
        ));

adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
@Override
public void onClick(RecyclerViewItem item) {
        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        });

        RecyclerView view = findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        new JsonFile(this, this).execute(JSON_FILE);
        }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        ArrayList<Mountain> listOfMountains = gson.fromJson(json, type);
        for(Mountain m : listOfMountains){
            items.add(new RecyclerViewItem(m.getName()));
        }
    }

}