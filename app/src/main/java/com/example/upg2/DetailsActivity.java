package com.example.upg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    TextView textViewName, textViewDescrip;
    ImageView imageView;

    String nom, descript;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textViewDescrip = findViewById(R.id.textView_description);
        textViewName = findViewById(R.id.textView_nom);
        imageView = findViewById(R.id.imageView_language);

        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("name") &&
                getIntent().hasExtra("description") &&
                getIntent().hasExtra("image")){
            descript = getIntent().getStringExtra("description");
            nom = getIntent().getStringExtra("name");
            images = getIntent().getIntExtra("image",1);
        }else{
            Toast.makeText(getApplicationContext(), "Npn Data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        textViewDescrip.setText(descript);
        textViewName.setText(nom);
        imageView.setImageResource(images);
    }





}