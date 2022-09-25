package com.example.upg2;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String description[], nom[];

    int images[] = {
            R.drawable.python, R.drawable.java_language, R.drawable.ruby,
            R.drawable.html, R.drawable.javascript, R.drawable.c_language,
            R.drawable.c_plus_plus, R.drawable.c_shap,
            R.drawable.objectivecc, R.drawable.phpimage,
            R.drawable.sql_logo, R.drawable.swift_laguage
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerview);

        description = getResources().getStringArray(R.array.description);
        nom = getResources().getStringArray(R.array.programming_languages);

        MyAdapter myAdapter = new MyAdapter(images,description,nom,this);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
