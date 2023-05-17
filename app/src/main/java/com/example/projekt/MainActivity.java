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
    private final String JSON_FILE = "hppoints.json";

    ArrayList<HPpoints> items = new ArrayList<>();
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
//@Override
//public void onClick(RecyclerViewItem item) {
  //      Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
   //     }
     //   });

       // RecyclerView view = findViewById(R.id.recycler_view);
        //view.setLayoutManager(new LinearLayoutManager(this));
        //view.setAdapter(adapter);

        new JsonFile(this, this).execute(JSON_FILE);
        }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<HPpoints>>() {}.getType();
        items = gson.fromJson(json, type);
        ArrayList<RecyclerViewItem> listOfHPpoints = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this, listOfHPpoints, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
            }
        });

        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);

    }

}